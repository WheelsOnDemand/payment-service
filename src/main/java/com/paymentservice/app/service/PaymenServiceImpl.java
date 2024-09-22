package com.paymentservice.app.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.paymentservice.app.config.ModelMapperService;
import com.paymentservice.app.dto.Messages;
import com.paymentservice.app.dto.request.CreatePaymentRequest;
import com.paymentservice.app.dto.response.CreatePaymentResponse;
import com.paymentservice.app.exception.BusinessException;
import com.paymentservice.app.model.Payment;
import com.paymentservice.app.repository.PaymentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymenServiceImpl implements PaymentService {
	private PaymentRepository paymentRepository;
	private ModelMapperService modelMapperService;
	private PosCheckService posCheckService;

	@Override
	public CreatePaymentResponse add(CreatePaymentRequest createPaymentRequest) { 
		
		//checkIfCardNumberExists(createPaymentRequest.getCardNo());
		Payment payment = modelMapperService.forRequest().map(createPaymentRequest, Payment.class);
		payment.setId(UUID.randomUUID().toString());
		paymentRepository.save(payment);
		CreatePaymentResponse createPaymentResponse = modelMapperService.forResponse().map(payment, CreatePaymentResponse.class);

		return createPaymentResponse;
	}

	@Override
	public void paymentReceived(String cardNo, String cardHolder, String cvv, double balance) {
		checkIfRentalBalance(cardNo, cardHolder, cvv, balance);

	}

	private void checkIfRentalBalance(String cardNo, String cardHolder, String cvv, double totalPrice) {
		Payment payment = this.paymentRepository.findByCardNoAndCardHolderAndCvv(cardNo, cardHolder, cvv);
		if (payment == null) {
			throw new BusinessException(Messages.InvalidPayment);
		}
		double amount = this.paymentRepository.findByCardNo(cardNo).getBalance();
		if (amount < totalPrice) {
			throw new BusinessException(Messages.InsufficientBalance);
		}
		posCheckService.pay();
		Payment payment2 = this.paymentRepository.findByCardNo(cardNo);
		payment2.setBalance(amount - totalPrice);
		this.paymentRepository.save(payment2);
	}

	@Override
	 public void delete(String id) {
        checkIfPaymentExists(id);
        paymentRepository.deleteById(id);
    }

	private void checkIfPaymentExists(String id) {
		  if (!paymentRepository.existsById(id)) {
	            throw new BusinessException(Messages.PaymentNotFound);
	        }
	    }
}
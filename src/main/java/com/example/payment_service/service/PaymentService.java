package com.example.payment_service.service;

import com.example.payment_service.dto.request.CreatePaymentRequest;
import com.example.payment_service.dto.response.CreatePaymentResponse;

public interface PaymentService {

	CreatePaymentResponse add(CreatePaymentRequest request);

	void paymentReceived(String cardNo,String cardHolder,String cvv,double balance); 
	void delete(String id);
}
package com.paymentservice.app.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paymentservice.app.dto.request.CreatePaymentRequest;
import com.paymentservice.app.dto.response.CreatePaymentResponse;
import com.paymentservice.app.service.PaymentService;

import javax.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentsController {
	private PaymentService paymentService;
	
	@PostMapping
	public CreatePaymentResponse add(@Valid @RequestBody CreatePaymentRequest createPaymentRequest) {
		return this.paymentService.add(createPaymentRequest);
	}
	
	@PostMapping("/received")
	public void paymentReceived(@RequestParam String cardNo, @RequestParam String cardHolder, @RequestParam String cvv,
			@RequestParam double totalPrice) {

		paymentService.paymentReceived(cardNo, cardHolder, cvv, totalPrice);

	}

	@DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        paymentService.delete(id);
    }
	

}
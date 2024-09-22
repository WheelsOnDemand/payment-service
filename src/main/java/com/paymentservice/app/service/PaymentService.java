package com.paymentservice.app.service;

import com.paymentservice.app.dto.request.CreatePaymentRequest;
import com.paymentservice.app.dto.response.CreatePaymentResponse;

public interface PaymentService {

	CreatePaymentResponse add(CreatePaymentRequest request);

	void paymentReceived(String cardNo,String cardHolder,String cvv,double balance); 
	void delete(String id);
}
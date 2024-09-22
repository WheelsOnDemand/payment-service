package com.paymentservice.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentResponse {
	private String id;
	private String cardNo;
	private String cardHolder;
	private String cvv;
	private String cardDate;
	private double balance;
}
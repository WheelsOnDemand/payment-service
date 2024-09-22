package com.paymentservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentservice.app.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String>{
	Payment findByCardNoAndCardHolderAndCvv(String cardNo,String cardHolder,String cvv);
	Payment findByCardNo(String cardNo);
}
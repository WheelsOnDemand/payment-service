package com.example.payment_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.payment_service.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String>{
	Payment findByCardNoAndCardHolderAndCvv(String cardNo,String cardHolder,String cvv);
	Payment findByCardNo(String cardNo);
}
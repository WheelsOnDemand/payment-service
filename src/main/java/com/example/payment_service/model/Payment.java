package com.example.payment_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="payments")
public class Payment {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "cardNo")
	private String cardNo;

	@Column(name = "cardHolder")
	private String cardHolder;

	@Column(name = "cvv")
	private String cvv;

	@Column(name = "cardDate")
	private String cardDate;

	@Column(name = "balance")
	private double balance;

	

}
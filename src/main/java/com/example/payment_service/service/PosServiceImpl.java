package com.example.payment_service.service;

import org.springframework.stereotype.Service;

@Service
public class PosServiceImpl implements PosCheckService {

	@Override
	public boolean pay() {
		return true;
	}

}
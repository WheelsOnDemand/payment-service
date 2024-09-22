package com.paymentservice.app.service;

import org.springframework.stereotype.Service;

@Service
public class PosServiceImpl implements PosCheckService {

	@Override
	public boolean pay() {
		return true;
	}

}
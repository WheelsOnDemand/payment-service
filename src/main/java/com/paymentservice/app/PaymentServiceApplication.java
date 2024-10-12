package com.paymentservice.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.paymentservice.app.config.ModelMapperService;
import com.paymentservice.app.config.ModelMapperServiceImpl;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public ModelMapperService getMapperService(ModelMapper modelMapper) {
		return new ModelMapperServiceImpl(modelMapper);
	}

}

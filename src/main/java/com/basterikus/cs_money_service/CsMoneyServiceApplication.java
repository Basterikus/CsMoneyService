package com.basterikus.cs_money_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CsMoneyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsMoneyServiceApplication.class, args);
	}

}

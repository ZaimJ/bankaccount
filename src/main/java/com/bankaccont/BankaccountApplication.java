package com.bankaccont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bankaccont.repository.AccountRepository;

@SpringBootApplication
public class BankaccountApplication {

	@Autowired
	private AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(BankaccountApplication.class, args);
	}
}

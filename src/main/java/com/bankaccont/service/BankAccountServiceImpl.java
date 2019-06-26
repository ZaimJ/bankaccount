package com.bankaccont.service;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.bankaccont.entities.BankAccount;

@Component
public class BankAccountServiceImpl implements BankAccountService{

	@Override public BankAccount findByAccountId(@NotNull Long accountId) {
		return null;
	}
}

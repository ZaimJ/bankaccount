package com.bankaccont.service;

import javax.validation.constraints.NotNull;

import com.bankaccont.entities.BankAccount;
import org.springframework.stereotype.Service;

@Service
public interface BankAccountService {

	BankAccount findByAccountId(@NotNull final Long accountId);

}

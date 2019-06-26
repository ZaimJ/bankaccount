package com.bankaccont.entities;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("WITHDRAWDEPOSIT_OP")
public class WithDrawDepositOperation extends OperationAbstract {

	public WithDrawDepositOperation(@NotNull BankAccount banckAccount,
			@NotNull float amount,
			@NotNull LocalDate operationDate) {
		super(banckAccount, amount, operationDate);
	}
}

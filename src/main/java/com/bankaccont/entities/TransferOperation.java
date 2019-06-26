package com.bankaccont.entities;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("TRANSFER_OP")
public class TransferOperation extends OperationAbstract {

	@NotNull
	private Long accountNumberReceiver;

	@NotNull
	private OperationType operationType;

	@NotBlank
	private String motif;


	@Builder
	public TransferOperation(@NotNull BankAccount bankAccount,
			@NotNull OperationType operationType,
			@NotNull float amount,
			@NotNull LocalDate operationDate,
			@NotNull Long accountNumberReceiver,
			@NotBlank String motif) {
		super(bankAccount, amount, operationDate);
		this.operationType = operationType;
		this.accountNumberReceiver = accountNumberReceiver;
		this.motif = motif;
	}
}

package com.bankaccont.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OPERATION", discriminatorType = DiscriminatorType.STRING, length = 20)
public abstract class OperationAbstract implements Serializable {

	@NotNull
	private final float amount;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long operationNumber;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_account")
	private BankAccount bankaccount;

	@NotNull
	private LocalDate operationDate;

	public OperationAbstract(@NotNull BankAccount bankAccount,
			@NotNull float amount,
			@NotNull LocalDate operationDate) {
		this.bankaccount = bankaccount;
		this.amount = amount;
		this.operationDate = operationDate;
	}
}

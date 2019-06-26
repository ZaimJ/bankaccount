package com.bankaccont.Test;

import com.bankaccont.entities.BankAccount;
import com.bankaccont.entities.OperationType;
import com.bankaccont.entities.TransferOperation;

import java.time.LocalDate;

public class OperationFactory {

	public static TransferOperation createTransferOperation(Long accountNumberReceiver) {

		return TransferOperation.builder()
				.accountNumberReceiver(accountNumberReceiver)
				.motif("Logement")
				.operationType(OperationType.DEBIT)
				.amount(1300.25f)
				.operationDate(LocalDate.now())
				.build();
	}

	public static BankAccount createBankAccount(Long accountNumber) {

		return BankAccount.builder().balance(13500.26f).currency("EUR").ownerAccount("Jon Doe").accountId(accountNumber).build();
	}

}

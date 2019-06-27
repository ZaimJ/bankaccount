package com.bankaccont.Test;

import com.bankaccont.entities.BankAccount;
import com.bankaccont.entities.OperationType;
import com.bankaccont.entities.TransferOperation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

	public static List<TransferOperation> createListTransferOperation(Long accountNumberReceiver) {
		List<TransferOperation> operations = new ArrayList<>();

		operations.add(TransferOperation.builder()
				.accountNumberReceiver(accountNumberReceiver)
				.motif("Logement")
				.operationType(OperationType.DEBIT)
				.amount(1300.25f)
				.operationDate(LocalDate.now())
				.build());
		operations.add(TransferOperation.builder()
				.accountNumberReceiver(accountNumberReceiver)
				.motif("Loisirs")
				.operationType(OperationType.CREDIT)
				.amount(88.25f)
				.operationDate(LocalDate.now())
				.build());

		return operations;
	}

	public static BankAccount createBankAccount(Long accountNumber) {

		return BankAccount.builder().balance(13500.26f).currency("EUR").ownerAccount("Jon Doe").accountId(accountNumber).build();
	}

}

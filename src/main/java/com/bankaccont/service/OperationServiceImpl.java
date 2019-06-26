package com.bankaccont.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bankaccont.entities.BankAccount;
import com.bankaccont.entities.OperationType;
import com.bankaccont.entities.TransferOperation;
import com.bankaccont.repository.AccountRepository;
import com.bankaccont.repository.OperationRepository;

@Component
public class OperationServiceImpl implements OperationService {

	private final OperationRepository operationRepository;

	private final AccountRepository accountRepository;

	@Autowired
	public OperationServiceImpl(OperationRepository operationRepository, AccountRepository accountRepository) {
		this.operationRepository = operationRepository;
		this.accountRepository = accountRepository;
	}

	@Override
	public Response depositAmount(Long accountId, float amount) throws Exception {
		if(amount < 0) throw new Exception("amount is negatif");
		BankAccount bankAccount = accountRepository.findByAccountId(accountId);
		bankAccount.setBalance(bankAccount.getBalance() + amount);
		accountRepository.save(bankAccount);
		return null;
	}

	@Override
	public Response withdrawAmount(Long accountId, float amount) throws Exception {
		if(amount < 0) throw new Exception("amount is negatif");
		BankAccount bankAccount = accountRepository.findByAccountId(accountId);
		bankAccount.setBalance(bankAccount.getBalance() - amount);
		accountRepository.save(bankAccount);
		return null;
	}

	@Override
	public Response transfer(Long accountId, Long destinationAccountId, float amount, String motif) throws Exception {
		if(amount < 0) throw new Exception("amount is negatif");
		BankAccount bankAccountSender = accountRepository.findByAccountId(accountId);
		BankAccount bankAccountreceiver = accountRepository.findByAccountId(destinationAccountId);
		bankAccountSender.setBalance(bankAccountSender.getBalance() - amount);
		bankAccountreceiver.setBalance(bankAccountreceiver.getBalance() + amount);
		bankAccountSender.getOperations().add(new TransferOperation(bankAccountSender, OperationType.DEBIT,amount,
				LocalDate.now(),destinationAccountId, motif));
		bankAccountreceiver.getOperations().add(new TransferOperation(bankAccountSender, OperationType.CREDIT,amount,
				LocalDate.now(), destinationAccountId, motif));
		accountRepository.save(bankAccountSender);
		accountRepository.save(bankAccountreceiver);
		return null;
	}

	@Override
	public List<TransferOperation>  history(Long accountId, OperationType operationType) {
		BankAccount bankAccount = accountRepository.findByAccountId(accountId);
		List<TransferOperation> operations = operationRepository.findByBankaccount(bankAccount);
		List<TransferOperation> operationsFrom = operations.stream().filter(operation->operation.getOperationType().equals(operationType)).collect(
				Collectors.toList());
		return operationsFrom;
	}
}

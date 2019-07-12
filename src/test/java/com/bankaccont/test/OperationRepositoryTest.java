package com.bankaccont.test;

import static junit.framework.TestCase.assertNotNull;

import javax.inject.Inject;

import com.bankaccont.entities.TransferOperation;
import com.bankaccont.repository.OperationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.bankaccont.entities.BankAccount;
import com.bankaccont.repository.AccountRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@Commit
public class OperationRepositoryTest {

	private static final Long ACCOUNT_ID_SENDER = 100000L;

	private static final Long ACCOUNT_ID_RECEIVER = 200000L;

	@Inject
	private OperationRepository operationRepository;

	@Inject
	private AccountRepository accountRepository;

	@Test
	public void it_should_create_and_save_operation() {
		// GIVEN
		TransferOperation transferOperation = OperationFactory.createTransferOperation(ACCOUNT_ID_RECEIVER);
		BankAccount bankAccount = OperationFactory.createBankAccount(ACCOUNT_ID_SENDER);
		bankAccount.getOperations().add(transferOperation);
		accountRepository.save(bankAccount);
		transferOperation.setBankaccount(bankAccount);
		// WHERE
		operationRepository.save(transferOperation);

		// THEN
		List<TransferOperation> operations = operationRepository.findByBankaccount(accountRepository.findByAccountId(ACCOUNT_ID_SENDER));
		assertNotNull(operations);

	}

}

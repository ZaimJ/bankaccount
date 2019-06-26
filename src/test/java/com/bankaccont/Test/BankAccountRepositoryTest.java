package com.bankaccont.Test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.bankaccont.entities.BankAccount;
import com.bankaccont.repository.AccountRepository;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@Commit
public class BankAccountRepositoryTest {

	private static final Long ACCOUNT_ID_SENDER = 100000L;

	@Inject
	private AccountRepository bankAccountRepository;

	@Test
	public void it_should_create_and_save_account() {
		// GIVEN
		BankAccount bankAccountSender = OperationFactory.createBankAccount(ACCOUNT_ID_SENDER);

		// WHERE
		bankAccountRepository.save(bankAccountSender);

		// THEN
		BankAccount bankAccountFromDB = bankAccountRepository.findByAccountId(ACCOUNT_ID_SENDER);
		assertNotNull(bankAccountFromDB);

	}

}

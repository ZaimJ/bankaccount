package com.bankaccont.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.bankaccont.entities.BankAccount;
import com.bankaccont.entities.TransferOperation;
import com.bankaccont.repository.AccountRepository;
import com.bankaccont.repository.OperationRepository;
import com.bankaccont.service.BankAccountService;
import com.bankaccont.service.OperationServiceImpl;

@DataJpaTest
@ContextConfiguration(classes = { AccountRepository.class, OperationRepository.class, BankAccountService.class })
public class OperationServiceTest {

	private static final Long ACCOUNT_ID_SENDER = 100000L;

	private static final Long ACCOUNT_ID_RECEIVER = 200000L;

	private static final float AMOUNT = 1325.70f;

	private static final float AMOUNT_NOT_VALID = -1325.70f;

	private static final String MOTIF = "Loisirs";

	private BankAccount bankAccountSender;

	private BankAccount bankAccountReceiver;

	private TransferOperation transferOperation;

	@Mock
	private AccountRepository accountRepository;

	@Mock
	private OperationRepository operationRepository;

	@Mock
	private BankAccountService bankAccountService;

	@InjectMocks
	private OperationServiceImpl operationServiceImpl;

	@Before
	public void init() throws InterruptedException {
		MockitoAnnotations.initMocks(this);
		this.bankAccountSender = OperationFactory.createBankAccount(ACCOUNT_ID_SENDER);
		this.bankAccountReceiver = OperationFactory.createBankAccount(ACCOUNT_ID_RECEIVER);
		this.transferOperation = OperationFactory.createTransferOperation(ACCOUNT_ID_RECEIVER);
		transferOperation.setBankaccount(bankAccountSender);
	}

	@Test
	public void should_not_deposit_amount_and_throw_exception() throws Exception {

		// GIVEN
		when(accountRepository.findByAccountId(anyLong())).thenReturn(bankAccountSender);
		float oldBalance = bankAccountSender.getBalance();
		float expectedBalance = oldBalance + AMOUNT_NOT_VALID;

		// WHEN
		operationServiceImpl.depositAmount(ACCOUNT_ID_RECEIVER, AMOUNT);

		// THEN
	}

	@Test
	public void should_deposit_amount() throws Exception {

		// GIVEN
		when(accountRepository.findByAccountId(anyLong())).thenReturn(bankAccountSender);
		float oldBalance = bankAccountSender.getBalance();
		float expectedBalance = oldBalance + AMOUNT;

		// WHEN
		operationServiceImpl.depositAmount(ACCOUNT_ID_RECEIVER, AMOUNT);

		// THEN
		assertEquals(expectedBalance, bankAccountSender.getBalance(),0.0);
	}

	@Test
	public void should_withdraw_amount() throws Exception {

		// GIVEN
		when(accountRepository.findByAccountId(anyLong())).thenReturn(bankAccountSender);
		float oldBalance = bankAccountSender.getBalance();
		float expectedBalance = oldBalance- AMOUNT;

		// WHEN
		operationServiceImpl.withdrawAmount(ACCOUNT_ID_RECEIVER, AMOUNT);

		// THEN
		assertEquals(expectedBalance, bankAccountSender.getBalance(), 0.0);
	}

	@Test
	public void should_transfer_amount() throws Exception {

		// GIVEN
		when(accountRepository.findByAccountId(anyLong())).thenReturn(bankAccountSender,bankAccountReceiver);
		float oldBalanceSender = bankAccountSender.getBalance();
		float expectedBalanceSender = oldBalanceSender - AMOUNT;
		float oldBalanceReceiver = bankAccountReceiver.getBalance();
		float expectedBalanceReceiver = oldBalanceReceiver + AMOUNT;

		// WHEN
		operationServiceImpl.transfer(ACCOUNT_ID_SENDER, ACCOUNT_ID_RECEIVER, AMOUNT, MOTIF);

		// THEN
		assertEquals(expectedBalanceSender, bankAccountSender.getBalance(),0.0);
		assertEquals(expectedBalanceReceiver, bankAccountReceiver.getBalance(),0.0);

	}

}

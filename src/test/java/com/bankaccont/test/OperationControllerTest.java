package com.bankaccont.test;

import com.bankaccont.entities.BankAccount;
import com.bankaccont.service.OperationService;
import com.bankaccont.controller.OperationController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(OperationController.class)
public class OperationControllerTest {

	private static final Long ACCOUNT_ID_SENDER = 100000L;

	@Autowired
	private MockMvc mvc;

	@MockBean
	private OperationService operationService;

	@Test
	public void should_deposit_amount() throws Exception {

		BankAccount bankAccountSender = OperationFactory.createBankAccount(ACCOUNT_ID_SENDER);
		given(operationService.depositAmount(ACCOUNT_ID_SENDER,1200)).willReturn()
		given(operationService.depositAmount(ACCOUNT_ID_SENDER,1200)).willReturn(Arrays.asList(account));


	}
}

package com.bankaccont.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankaccont.entities.OperationType;
import com.bankaccont.entities.TransferOperation;

@Service
public interface OperationService {

	void depositAmount(final Long accountId, final float amount) throws Exception;

	void withdrawAmount(final Long accountId, final float amount) throws Exception;

	@Transactional
	void transfer(final Long accountId, final Long destinationAccountId, final float amount, final String motif)
			throws Exception;

	List<TransferOperation> history(final Long accountId, final OperationType operationType);

}

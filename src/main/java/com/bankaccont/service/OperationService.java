package com.bankaccont.service;

import java.util.List;

import javax.xml.ws.Response;

import com.bankaccont.entities.OperationType;
import com.bankaccont.entities.TransferOperation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public interface OperationService {

	Response depositAmount(final Long accountId, final float amount) throws Exception;

	Response withdrawAmount(final Long accountId, final float amount) throws Exception;

	@Transactional
	Response transfer(final Long accountId,
			final Long destinationAccountId,
			final float amount,
			final String motif) throws Exception;

	List<TransferOperation> history(final Long accountId, final OperationType operationType);

}

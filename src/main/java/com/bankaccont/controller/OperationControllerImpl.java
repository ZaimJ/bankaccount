package com.bankaccont.controller;

import java.util.List;

import javax.ws.rs.core.Response;

import com.bankaccont.entities.OperationType;
import com.bankaccont.entities.TransferOperation;
import com.bankaccont.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationControllerImpl implements OperationController {

	private final OperationService operationService;

	@Autowired
	public OperationControllerImpl(OperationService operationService) {
		this.operationService = operationService;
	}

	@Override
	public Response depositAmount(Long accountId, float amount) throws Exception {
		operationService.depositAmount(accountId, amount);
		return Response.status(Response.Status.OK).entity("deposit done").build();
	}

	@Override
	public Response withdrawAmount(Long accountId, float amount) throws Exception {
		operationService.withdrawAmount(accountId, amount);
		return Response.status(Response.Status.OK).entity("withdraw done").build();
	}

	@Override
	public Response transfer(Long accountId, Long destinationAccountId, float amount, String motif) throws Exception {

		operationService.transfer(accountId, destinationAccountId, amount, motif);
		return Response.status(Response.Status.OK).entity("Transfer done").build();
	}

	@Override
	public Response historyFrom(Long accountId) {

		List<TransferOperation> listOperationsFrom = operationService.history(accountId, OperationType.DEBIT);
		return Response.status(Response.Status.OK).entity(listOperationsFrom).build();
	}

	@Override
	public Response historyTo(Long accountId) {

		List<TransferOperation> listOperationsTo = operationService.history(accountId, OperationType.CREDIT);
		return Response.status(Response.Status.OK).entity(listOperationsTo).build();
	}
}

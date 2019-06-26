package com.bankaccont.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.bankaccont.entities.BankAccount;
import com.bankaccont.entities.OperationAbstract;
import com.bankaccont.entities.TransferOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OperationRepository extends JpaRepository<OperationAbstract, Long> {

	List<TransferOperation> findByBankaccount(@NotNull BankAccount bankAccount);

}

package com.bankaccont.repository;

import javax.validation.constraints.NotNull;

import com.bankaccont.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AccountRepository extends JpaRepository<BankAccount, Long> {

	BankAccount findByAccountId(@NotNull final Long accountId);

}

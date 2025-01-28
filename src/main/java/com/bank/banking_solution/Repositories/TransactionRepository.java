package com.bank.banking_solution.Repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.banking_solution.Models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    @Query(value = "SELECT * FROM transactions WHERE account_id = :accountId ORDER BY created_at DESC", nativeQuery = true)
    List<Transaction> findByAccountId(@Param("accountId") UUID accountId);

}

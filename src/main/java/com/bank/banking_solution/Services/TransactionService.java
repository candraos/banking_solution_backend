package com.bank.banking_solution.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bank.banking_solution.DTOs.TransactionResponseDTO;
import com.bank.banking_solution.Models.Transaction;
import com.bank.banking_solution.Repositories.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    //functions to create
    //create transaction
    //get transaction of account

    public List<Transaction> getTransactions(UUID accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

   
    
}

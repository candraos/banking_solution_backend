package com.bank.banking_solution.Controllers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bank.banking_solution.DTOs.TransactionResponseDTO;
import com.bank.banking_solution.Models.Transaction;
import com.bank.banking_solution.Services.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/getall/{accountId}")
    public ResponseEntity<List<TransactionResponseDTO>> getAllTransactions(@PathVariable UUID accountId) {
        List<Transaction> transactions = transactionService.getTransactions(accountId);
        List<TransactionResponseDTO> transactionResponseDTOs = transactions.stream()
                .map(transaction -> modelMapper.map(transaction, TransactionResponseDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(transactionResponseDTOs);
    }
}

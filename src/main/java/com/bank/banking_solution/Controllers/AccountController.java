package com.bank.banking_solution.Controllers;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bank.banking_solution.DTOs.AccountDTO;
import com.bank.banking_solution.DTOs.AccountResponseDTO;
import com.bank.banking_solution.DTOs.TransactionRequestDTO;
import com.bank.banking_solution.DTOs.TransactionResponseDTO;
import com.bank.banking_solution.Models.Account;
import com.bank.banking_solution.Models.Transaction;
import com.bank.banking_solution.Services.AccountService;


@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/getAll/{customerId}")
    public ResponseEntity<List<AccountResponseDTO>> getAccount(@PathVariable UUID customerId) {
        List<Account> accounts = accountService.getCustomerAccounts(customerId);
        List<AccountResponseDTO> accountResponseDTOs = accounts.stream().map(account -> modelMapper.map(account, AccountResponseDTO.class)).toList();
        return new ResponseEntity<List<AccountResponseDTO>>(accountResponseDTOs, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
        
        Account account = accountService.createAccount(accountDTO);
        AccountDTO newAccount = modelMapper.map(account, AccountDTO.class);
        return new ResponseEntity<AccountDTO>(newAccount,HttpStatus.CREATED);
    }

    @PostMapping("/makeTransaction")
    public ResponseEntity<TransactionResponseDTO> makeTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        Transaction createdTransaction = accountService.makeTransaction(transactionRequestDTO);
        TransactionResponseDTO newTransaction = modelMapper.map(createdTransaction, TransactionResponseDTO.class);
        return new ResponseEntity<TransactionResponseDTO>(newTransaction, HttpStatus.CREATED);
    }
 
}

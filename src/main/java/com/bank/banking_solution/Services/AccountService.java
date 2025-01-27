package com.bank.banking_solution.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.banking_solution.DTOs.AccountDTO;
import com.bank.banking_solution.DTOs.TransactionRequestDTO;
import com.bank.banking_solution.Models.Account;
import com.bank.banking_solution.Models.Transaction;
import com.bank.banking_solution.Models.Account.AccountStatus;
import com.bank.banking_solution.Repositories.AccountRepository;
import com.bank.banking_solution.Repositories.TransactionRepository;
import com.bank.banking_solution.Repositories.UserRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository  userRepository;

    @Autowired
    private ModelMapper modelMapper;
    //functions to create
    //create account
    //deposit
    //withdraw

    public Account createAccount(AccountDTO accountDTO) {
        Account account = modelMapper.map(accountDTO, Account.class);
        account.setBalance(0);
        account.setStatus(AccountStatus.ACTIVE);
        account.setOwner(userRepository.findById(accountDTO.getOwnerId()).get());    
        return accountRepository.save(account);
        
    }

    public Transaction makeTransaction(TransactionRequestDTO transactionRequestDTO) {
        Optional<Account> account = accountRepository.findById(transactionRequestDTO.getAccountId());
       if(account.isPresent()) {
        Account accountSelected = account.get();
        if(transactionRequestDTO.isDeposit()) {
            accountSelected.setBalance(accountSelected.getBalance() + transactionRequestDTO.getAmount());
        } else {
            if(accountSelected.getBalance() < transactionRequestDTO.getAmount()) {
                return null;
            }
            accountSelected.setBalance(accountSelected.getBalance() - transactionRequestDTO.getAmount());
        }

        accountRepository.save(accountSelected);
        Transaction transaction =  Transaction.builder()
                .account(accountSelected)
                
                .amount(transactionRequestDTO.getAmount())
                .status(transactionRequestDTO.isDeposit() ? Transaction.TransactionStatus.DEPOSIT : Transaction.TransactionStatus.WITHDRAW)
                .createdAt(LocalDateTime.now())
                .build();
        return transactionRepository.save(transaction);
        
    }
    return null;
    
}

    public List<Account> getCustomerAccounts(UUID customerId) {
        return accountRepository.findByOwnerId(customerId);
    }
}

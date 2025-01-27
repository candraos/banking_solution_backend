package com.bank.banking_solution.DTOs;

import java.time.LocalDateTime;
import java.util.UUID;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseDTO {
    private UUID id;

    private TransactionStatus status;

    public enum TransactionStatus {
        WITHDRAW,
        DEPOSIT
    }
     private double amount;
    private LocalDateTime createdAt;

     
}
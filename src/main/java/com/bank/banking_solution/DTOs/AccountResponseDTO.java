package com.bank.banking_solution.DTOs;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AccountResponseDTO {
private UUID id;

    private double balance;

    private AccountStatus status;

    public enum AccountStatus {
        ACTIVE,
        INACTIVE,
        CLOSED
    }

   
    private LocalDateTime createdAt;

}

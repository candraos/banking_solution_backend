package com.bank.banking_solution.DTOs;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequestDTO {
    

    
     private double amount;
    
     @JsonProperty("isDeposit")
     private boolean isDeposit;

     
     public boolean isDeposit() {
        return isDeposit;
    }

    public void setDeposit(boolean isDeposit) {
        this.isDeposit = isDeposit;
    }
     
    private UUID accountId;
}
package com.bank.banking_solution.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Builder
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    public enum TransactionStatus {
        WITHDRAW,
        DEPOSIT
    }
     private double amount;
     
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

     @ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    private Account account;
    
}
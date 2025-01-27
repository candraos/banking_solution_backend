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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;

    private double balance;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    public enum AccountStatus {
        ACTIVE,
        INACTIVE,
        CLOSED
    }

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

      @ManyToOne
    @JoinColumn(name="owner_id", nullable=false)
    private UserEntity owner;
    

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions = new ArrayList<Transaction>();
}
package com.bank.banking_solution.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class UserEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;

    private String username;

    private String password;

    @Column(name="is_admin")
    private boolean isAdmin;

    @OneToMany(mappedBy = "owner")
    private List<Account> accounts = new ArrayList<Account>();
    
}
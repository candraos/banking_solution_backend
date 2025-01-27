package com.bank.banking_solution.Repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.banking_solution.Models.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    UserEntity findByUsername(String username);

    @Query("SELECT u FROM UserEntity u WHERE u.isAdmin = false order by u.username desc")
    List<UserEntity> findAllCustomers();

}

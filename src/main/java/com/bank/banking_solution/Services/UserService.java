package com.bank.banking_solution.Services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bank.banking_solution.DTOs.UserDTO;
import com.bank.banking_solution.Models.UserEntity;
import com.bank.banking_solution.Repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserEntity> getAllCustomers() {
        return userRepository.findAllCustomers();
    }

    public UserEntity createUser(UserDTO userDTO) {
        UserEntity user = modelMapper.map(userDTO, UserEntity.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAdmin(false);
        return userRepository.save(user);
    }

    public UserEntity login(UserDTO userDto) {
        UserEntity user = userRepository.findByUsername(userDto.getUsername());
        if(user != null && passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            return user;
        }
        return null;
    }
    
}

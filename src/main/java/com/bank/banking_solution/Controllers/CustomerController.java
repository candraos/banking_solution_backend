package com.bank.banking_solution.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bank.banking_solution.DTOs.UserDTO;
import com.bank.banking_solution.Models.UserEntity;
import com.bank.banking_solution.Services.UserService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private UserService customerService;

    @Autowired
    private ModelMapper modelMapper;

    
    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAllCustomers() {
        List<UserEntity> users = customerService.getAllCustomers();
        List<UserDTO> userDTOs = users.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<List<UserDTO>>(userDTOs,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createCustomer(@RequestBody UserDTO userDto) {
    
        UserEntity user = customerService.createUser(userDto);
        UserDTO newUser = modelMapper.map(user, UserDTO.class);
        return new ResponseEntity<UserDTO>(newUser,HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDto) {
        UserEntity user = customerService.login(userDto);
        UserDTO newUser = modelMapper.map(user, UserDTO.class);
        return new ResponseEntity<UserDTO>(newUser,HttpStatus.OK);
    }
}

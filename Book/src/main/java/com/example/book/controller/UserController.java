package com.example.book.controller;

import com.example.book.DTO.ResponseAPI;
import com.example.book.model.User;
import com.example.book.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        logger.info("getUsers in user controller used");
        return ResponseEntity.status(200).body(userService.getUsers());
    }
    @PostMapping
    public ResponseEntity<ResponseAPI> addUser(@RequestBody @Valid User user){
        logger.info("addUser in user controller used");
        userService.addUser(user);
        return ResponseEntity.status(201).body(new ResponseAPI("User added",201));
    }
}

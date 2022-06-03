package com.example.book.service;

import com.example.book.Exceptions.UserNotFoundException;
import com.example.book.model.User;
import com.example.book.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public void addUser(User user){
        userRepository.save(user);
    }
    public User findUserByID(Integer id){
        User user = userRepository.findById(id).get();
        if(user == null){
            throw new UserNotFoundException("Couldn't find a user with the id"+id);
        }
        return user;
    }
}

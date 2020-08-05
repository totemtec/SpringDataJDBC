package com.example.custom;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> searchUser(String name, String mobile)
    {
        List<User> userList = userRepository.findUser(name, mobile);
        return userList;
    }

}

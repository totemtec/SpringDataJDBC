package com.example.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/user/search")
    public List<User> searchUser(@RequestParam String name,
                                 @RequestParam String mobile)
    {
        return userService.searchUser(name, mobile);
    }
}

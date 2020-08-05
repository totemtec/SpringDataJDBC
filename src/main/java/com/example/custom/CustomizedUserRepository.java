package com.example.custom;

import java.util.List;

interface CustomizedUserRepository {
    List<User> findUser(String name, String mobile);
}
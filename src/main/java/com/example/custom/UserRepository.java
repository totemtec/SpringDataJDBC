package com.example.custom;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>, CustomizedUserRepository {

}

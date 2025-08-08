package com.example.userservice.service;

import com.example.userservice.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface IUserService {

    User create(User user);

    Optional<User> findById(UUID userId);
}

package com.example.userservice.service.impl;

import com.example.userservice.entity.User;
import com.example.userservice.repo.UserRepo;
import com.example.userservice.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User create(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> findById(UUID userId) {
        return userRepo.findById(userId);
    }
}

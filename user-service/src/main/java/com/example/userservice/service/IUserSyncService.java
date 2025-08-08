package com.example.userservice.service;

import com.example.userservice.entity.User;
import reactor.core.publisher.Mono;

public interface IUserSyncService {

    Mono<User> getOrCreateUser(String accessToken, String userId);
}

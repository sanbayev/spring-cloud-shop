package com.example.userservice.service.impl;

import com.example.userservice.converter.ProfileConverter;
import com.example.userservice.dto.ProfileDto;
import com.example.userservice.entity.User;
import com.example.userservice.service.IUserProfileService;
import com.example.userservice.service.IUserSyncService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserProfileServiceImpl implements IUserProfileService {

    private final IUserSyncService userSyncService;
    private final ProfileConverter profileConverter;

    public UserProfileServiceImpl(IUserSyncService userSyncService, ProfileConverter profileConverter) {
        this.userSyncService = userSyncService;
        this.profileConverter = profileConverter;
    }

    @Override
    public ProfileDto createOrGetProfile(String token, String userId) {
        Mono<User> orCreateUser = userSyncService.getOrCreateUser(token, userId);
        return profileConverter.toDto(orCreateUser.block());
    }
}

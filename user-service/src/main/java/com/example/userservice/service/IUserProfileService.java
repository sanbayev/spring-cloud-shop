package com.example.userservice.service;

import com.example.userservice.dto.ProfileDto;

public interface IUserProfileService {

    ProfileDto createOrGetProfile(String token, String userId);
}

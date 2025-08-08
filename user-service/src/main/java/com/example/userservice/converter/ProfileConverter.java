package com.example.userservice.converter;

import com.example.userservice.dto.ProfileDto;
import com.example.userservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ProfileConverter {

    public ProfileDto toDto(User user) {
        if (user == null) {
            return null;
        }

        return new ProfileDto(
                user.getId(),
                user.getCreatedAt(),
                user.getUserName(),
                user.getEmail()
        );
    }
}
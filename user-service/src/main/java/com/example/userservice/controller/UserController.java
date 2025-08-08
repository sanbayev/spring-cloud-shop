package com.example.userservice.controller;

import com.example.userservice.dto.ProfileDto;
import com.example.userservice.service.IUserProfileService;
import com.example.userservice.utils.TokenUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final IUserProfileService userProfileService;

    public UserController(IUserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping("/profile")
    public ProfileDto getProfile(@RequestHeader("X-User-Id") String userId,
                                 HttpServletRequest serverHttpRequest) {
        String authToken = TokenUtils.extractTokenFromRequest(serverHttpRequest);
        return userProfileService.createOrGetProfile(authToken, userId);
    }
}

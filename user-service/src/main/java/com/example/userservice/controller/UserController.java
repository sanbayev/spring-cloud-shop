package com.example.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/hello")
    public String helloUser(@RequestHeader("X-User-Id") String userId,
                            @RequestHeader(value = "X-User-Email", required = false) String email) {
        return "Hello from User Service! " + userId + " " + email;
    }
}

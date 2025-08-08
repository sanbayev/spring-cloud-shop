package com.example.userservice.service.impl;

import com.example.userservice.entity.User;
import com.example.userservice.service.IUserService;
import com.example.userservice.service.IUserSyncService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
public class UserSyncServiceImpl implements IUserSyncService {

    @Value("${keycloak.userinfo-uri}")
    private String userInfoUri;

    private final IUserService iUserService;
    private final WebClient webClient;


    public UserSyncServiceImpl(IUserService iUserService, WebClient.Builder webClientBuilder) {
        this.iUserService = iUserService;
        this.webClient = webClientBuilder.build();
    }

    @Override
    public Mono<User> getOrCreateUser(String accessToken, String userId) {
        return Mono.just(accessToken)
                .flatMap(token -> {
                    UUID userUuid = UUID.fromString(userId);
                    return iUserService.findById(userUuid)
                            .map(Mono::just)
                            .orElseGet(() ->
                                    fetchUserInfo(token)
                                            .flatMap(userInfo -> {
                                                User user = new User();
                                                LocalDateTime currentTime = LocalDateTime.now();

                                                user.setId(userUuid);
                                                user.setUserName(userInfo.get("preferred_username"));
                                                user.setEmail(userInfo.get("email"));
                                                user.setCreatedAt(currentTime);
                                                user.setUpdatedAt(currentTime);
                                                return Mono.just(iUserService.create(user));
                                            })
                            );
                });
    }

    private Mono<Map<String, String>> fetchUserInfo(String token) {
        return webClient.get()
                .uri(userInfoUri)
                .headers(headers -> headers.setBearerAuth(token))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {
                });
    }
}

package com.fitness.activity.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@AllArgsConstructor
public class UserServiceValidation {
    private WebClient webClient;

    public boolean validate(Integer userId) {
        try {
            return Boolean.TRUE.equals(webClient.get().uri("api/users/{userId}/validate", userId).retrieve().bodyToMono(Boolean.class).block());
        }
        catch (WebClientResponseException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new RuntimeException("User Id not found " + userId);
            } else if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new RuntimeException("Invalid request " + userId);
            } else {
                throw new RuntimeException("Something went wrong");
            }
        }
    }
}

package com.fitness.userservice.Controller;

import com.fitness.userservice.Service.UserService;
import com.fitness.userservice.dto.RegiserRequest;
import com.fitness.userservice.dto.UserResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserProfile(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegiserRequest request) {
        return new ResponseEntity<>(userService.register(request), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/validate")
    public ResponseEntity<Boolean> checkUserExist(@PathVariable Integer userId) {
        return new ResponseEntity<>(userService.existByUserId(userId), HttpStatus.OK);
    }
}

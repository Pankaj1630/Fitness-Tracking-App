package com.fitness.userservice.Service;

import com.fitness.userservice.Model.User;
import com.fitness.userservice.Repository.UserRepository;
import com.fitness.userservice.dto.RegiserRequest;
import com.fitness.userservice.dto.UserResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    //constructor injection
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserResponse register(RegiserRequest request) {
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        User user = modelMapper.map(request, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponse.class);
    }

    public UserResponse getUserProfile(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not found"));
        return modelMapper.map(user, UserResponse.class);
    }


    public Boolean existByUserId(Integer userId) {
        return userRepository.existsById(userId);
    }
}

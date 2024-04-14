package com.vuongnm.service.implement;

import com.vuongnm.model.User;
import com.vuongnm.payload.ApiResponse;
import com.vuongnm.repository.UserRepository;
import com.vuongnm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<ApiResponse<List<User>>> getAll() {
        return ApiResponse.buildResponse(userRepository.findAll(), "success", true, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse<User>> createUser(User user) {
        return ApiResponse.buildResponse(userRepository.save(user), "success", true, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse<User>> getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return ApiResponse.buildResponse(optionalUser.get(), "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(null, "fail", false, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<ApiResponse<User>> getUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUserName(username);
        if (optionalUser.isPresent()) {
            return ApiResponse.buildResponse(optionalUser.get(), "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(null, "fail", false, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        if (userRepository.findById(id) != null) {
            userRepository.deleteById(id);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<ApiResponse<User>> updateUser(Long userId, User updatedUser) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setUserName(updatedUser.getUserName());
            existingUser.setPassword(updatedUser.getPassword());
            return ApiResponse.buildResponse(userRepository.save(existingUser), "success", true, HttpStatus.OK);
        } else {
            return ApiResponse.buildResponse(null, "success", true, HttpStatus.NOT_FOUND);
        }
    }
}

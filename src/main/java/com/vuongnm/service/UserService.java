package com.vuongnm.service;

import com.vuongnm.model.User;
import com.vuongnm.payload.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserService {

    public ApiResponse<List<User>> getAll();

    public ResponseEntity<ApiResponse<User>> createUser(User user);

    public ResponseEntity<ApiResponse<User>> getUserById(Long id);

    public ResponseEntity<ApiResponse<User>> getUserByUsername(String userName);

    public ResponseEntity<String> deleteById(Long id);

    public ResponseEntity<ApiResponse<User>> updateUser(Long userId, User updatedUser);
}

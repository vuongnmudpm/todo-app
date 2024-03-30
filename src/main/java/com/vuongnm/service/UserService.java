package com.vuongnm.service;

import com.vuongnm.model.User;
import com.vuongnm.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public boolean deleteById(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public User updateUser(Long userId, User updatedUser) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            // Cập nhật các trường khác nếu cần
            return userRepository.save(existingUser);
        } else {
            throw new EntityNotFoundException("User not found with ID: " + userId);
        }
    }
}

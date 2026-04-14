package com.marketplace.marketplace_api.service;

import com.marketplace.marketplace_api.dto.UserDTO;
import com.marketplace.marketplace_api.entity.User;
import com.marketplace.marketplace_api.exception.UserNotFoundException;
import com.marketplace.marketplace_api.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserDTO mapToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername()
        );
    }

    public UserDTO createUser(UserDTO userDTO) {
        User newUser = new User();
        newUser.setUsername(userDTO.getUsername());
        return mapToDTO(userRepository.save(newUser));
    }
}

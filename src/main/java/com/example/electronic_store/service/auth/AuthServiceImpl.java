package com.example.electronic_store.service.auth;

import com.example.electronic_store.dto.request.SignUpDto;
import com.example.electronic_store.entity.Customer;
import com.example.electronic_store.entity.User;
import com.example.electronic_store.exception.IllegalArgumentException;
import com.example.electronic_store.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserDetails signUp(SignUpDto data) {
        if (loadUserByUsername(data.username()) != null) {
            throw new IllegalArgumentException("Username already exists");
        }
        String encryptedPassword = passwordEncoder.encode(data.password());
        User newUser = new User(data.username(), encryptedPassword, data.role());
        Customer customer = new Customer(data.name(), newUser);
        newUser.setCustomer(customer);
        return userRepository.save(newUser);
    }
}

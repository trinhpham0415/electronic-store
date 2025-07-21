package com.example.electronic_store.service.auth;

import com.example.electronic_store.dto.request.SignUpDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    UserDetails signUp(SignUpDto data);
}

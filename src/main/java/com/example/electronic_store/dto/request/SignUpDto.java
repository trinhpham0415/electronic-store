package com.example.electronic_store.dto.request;

import com.example.electronic_store.constant.UserRole;

public record SignUpDto(
    String name,
    String username,
    String password,
    UserRole role) {
}

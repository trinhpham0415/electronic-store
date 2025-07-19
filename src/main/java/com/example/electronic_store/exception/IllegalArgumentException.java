package com.example.electronic_store.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IllegalArgumentException extends RuntimeException {
    public IllegalArgumentException(String message) {
        super(message);
    }
}

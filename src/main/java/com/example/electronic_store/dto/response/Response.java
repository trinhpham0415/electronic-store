package com.example.electronic_store.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Response {
    private String message;
    private Object data;

    public Response(String message) {
        this.message = message;
    }

    public Response(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}

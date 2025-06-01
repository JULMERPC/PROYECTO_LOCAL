package com.example.ms.proveedor.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;


public class ProveedorNotFoundException extends RuntimeException {
    public ProveedorNotFoundException(String message) {
        super(message);
    }
}
package com.mrityunjoy24.productservice3.exceptions;

import lombok.Getter;

@Getter

public class NotFoundException extends Exception{
    public NotFoundException(String message) {
        super(message);
    }
}

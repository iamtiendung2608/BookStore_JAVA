package com.example.demo.Exception;

public class PasswordMissMatchException extends  Exception {
    public PasswordMissMatchException(String message) {
        super(message);
    }
}

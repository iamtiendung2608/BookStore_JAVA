package com.example.demo.Security;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String user_already_exist) {
        super(user_already_exist);
    }
}

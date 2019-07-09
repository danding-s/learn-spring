package com.learn.service;

public class ShiroService {
    public String getPasswordByUsername(String username) {
        switch (username) {
            case "u1":
                return "123";
            case "u2":
                return "1234";
            default:
                return null;
        }
    }
}

package com.mobile.test.login.domain.model;

public class Auth {
    private String email;
    private String password;

    public Auth() {
        this("", "");
    }

    public Auth(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

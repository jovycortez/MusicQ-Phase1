package com.group6.mobileappdev.musicq_phase1;

/**
 * Created by Jovy on 4/10/2016.
 */
public class User {

    String username, email, password;
    int age;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String password) {
        this(username,"",password);
    }
}
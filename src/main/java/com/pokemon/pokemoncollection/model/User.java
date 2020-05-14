package com.pokemon.pokemoncollection.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

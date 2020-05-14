package com.pokemon.pokemoncollection.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {
    private String email;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

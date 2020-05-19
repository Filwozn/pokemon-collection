package com.pokemon.pokemoncollection.model;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private String type;
    private int coins = 500;
    private List<Card> cards = new ArrayList<>();
    private String email;

    public Trainer(String name, String type, String email) {
        this.name = name;
        this.type = type;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", coins=" + coins +
                ", cards=" + cards +
                ", email='" + email + '\'' +
                '}';
    }
}

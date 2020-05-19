package com.pokemon.pokemoncollection.model;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private String type;
    private int coins = 500;
    private List<Card> cards = new ArrayList<>();

    public Trainer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", coins=" + coins +
                ", cards=" + cards +
                '}';
    }
}

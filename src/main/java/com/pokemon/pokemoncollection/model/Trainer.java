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

    public int getCoins() {
        return coins;
    }

    public String getEmail() {
        return email;
    }

    public void addPack(List<Card>cards){
        this.cards.addAll(cards);
    }

    public void payForPack(int packPrice){
        coins = coins - packPrice;
    }

    public List<Card> getCards() {
        return cards;
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

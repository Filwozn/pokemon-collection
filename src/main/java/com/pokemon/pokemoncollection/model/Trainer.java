package com.pokemon.pokemoncollection.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trainer {
    private String name;
    private String type;
    private int coins = 500;
    @ManyToMany
    private List<Card> cards = new ArrayList<>();
    @Id
    private String email;

    public Trainer(String name, String type, String email) {
        this.name = name;
        this.type = type;
        this.email = email;
    }

    public Trainer(){}

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

    public void addCoins(int coins){
        this.coins += coins;
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

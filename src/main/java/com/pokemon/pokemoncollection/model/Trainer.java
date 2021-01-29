package com.pokemon.pokemoncollection.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.*;

@Entity
public class Trainer {
    private String name;
    private String type;
    private int coins = 500;
    @ElementCollection
    private Map<Card, Integer> cards = new HashMap<>();
    @Id
    private String email;

    public Trainer(String name, String type, String email) {
        this.name = name;
        this.type = type;
        this.email = email;
    }

    public Trainer(){}

    public void addCard(Card card) {
        if(cards.containsKey(card)){
         int amount = cards.get(card);
         cards.put(card, amount +1);

        }else {
            cards.put(card, 1);
        }
        }
    public void removeCard(Card card, int amount){
        if(cards.containsKey(card)) {
            cards.put(card, cards.get(card) - amount);
        }
        if(cards.get(card) <= 0){
            cards.remove(card);
        }
    }

    public int getCoins() {
        return coins;
    }

    public String getEmail() {
        return email;
    }

    public void addPack(List<Card>cards){
        for (Card card : cards) {
            addCard(card);
        }
    }

    public void payForPack(int packPrice){
        coins = coins - packPrice;
    }

    public Map<Card, Integer> getCards() {
        return cards;
    }

    public void addCoins(int coins){
        this.coins += coins;
    }

    public int getCardAmount(Card card){
        return cards.getOrDefault(card, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return email.equals(trainer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    public String getName() {
        return name;
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

//r2:
//trener: Map<Card, Inteeger>


//klucz -> wartosc

//email -> user




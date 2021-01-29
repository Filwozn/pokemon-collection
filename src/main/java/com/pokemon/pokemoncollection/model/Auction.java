package com.pokemon.pokemoncollection.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Auction {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Card card;
    private int price;
    private int cardAmount;
    @ManyToOne
    private Trainer seller;

    public Auction(Card card, int price, int cardAmount, Trainer seller) {
        this.card = card;
        this.price = price;
        this.cardAmount = cardAmount;
        this.seller = seller;
    }
    public Auction(){
    }

    public int getId() {
        return id;
    }

    public Card getCard() {
        return card;
    }

    public int getPrice() {
        return price;
    }

    public int getCardAmount() {
        return cardAmount;
    }

    public Trainer getSeller() {
        return seller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auction auction = (Auction) o;
        return id == auction.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Auction{" +
                "id=" + id +
                ", card=" + card +
                ", price=" + price +
                ", cardAmount=" + cardAmount +
                ", seller=" + seller +
                '}';
    }
}

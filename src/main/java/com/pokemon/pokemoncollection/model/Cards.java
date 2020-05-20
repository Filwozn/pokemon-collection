package com.pokemon.pokemoncollection.model;

import java.util.List;

public class Cards {
    private List<Card> cards;

    public Cards() {
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "cardList=" + cards +
                '}';
    }
}

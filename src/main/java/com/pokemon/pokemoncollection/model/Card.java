package com.pokemon.pokemoncollection.model;

import java.util.List;

public class Card {
    private String id;
    private String name;
    private String imageUrl;
    private List<String> types;
    private String rarity;

    public Card() {
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<String> getTypes() {
        return types;
    }

    public String getRarity() {
        return rarity;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", type=" + types +
                ", rarity='" + rarity + '\'' +
                '}';
    }
}

package com.pokemon.pokemoncollection.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Card {
    @Id
    private String id;
    private String name;
    private String imageUrl;
    @ElementCollection
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

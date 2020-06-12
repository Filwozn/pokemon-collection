package com.pokemon.pokemoncollection.client.tamplates;

import com.pokemon.pokemoncollection.model.Set;

import java.util.List;

public class AllSets {
    private List<Set> sets;

    public List<Set> getSets() {
        return sets;
    }

    @Override
    public String toString() {
        return "AllSets{" +
                "allSets=" + sets +
                '}';
    }
}

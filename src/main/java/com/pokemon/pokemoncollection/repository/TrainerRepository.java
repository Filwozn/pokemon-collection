package com.pokemon.pokemoncollection.repository;

import com.pokemon.pokemoncollection.model.Trainer;

public interface TrainerRepository {
    Trainer save(Trainer trainer);
    Trainer findByEmail(String email);
}

package com.pokemon.pokemoncollection.repository;

import com.pokemon.pokemoncollection.model.User;

public interface UserRepository {
    User save (User user);
    User findByEmail(String email);
}

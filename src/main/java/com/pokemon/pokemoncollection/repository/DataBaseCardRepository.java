package com.pokemon.pokemoncollection.repository;

import com.pokemon.pokemoncollection.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataBaseCardRepository extends JpaRepository<Card, String> {
}

package com.pokemon.pokemoncollection.repository;

import com.pokemon.pokemoncollection.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Auction,Integer>{
}

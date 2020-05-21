package com.pokemon.pokemoncollection.repository;

import com.pokemon.pokemoncollection.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface DataBaseUserRepository extends UserRepository, JpaRepository<User,String>{
}

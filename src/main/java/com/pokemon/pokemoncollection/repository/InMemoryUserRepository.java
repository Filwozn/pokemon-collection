package com.pokemon.pokemoncollection.repository;

import com.pokemon.pokemoncollection.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class InMemoryUserRepository implements UserRepository{
    private List<User>users = new ArrayList<>();
    @Override
    public void save(User user) {
        users.add(user);
        System.out.println(users);
    }
}

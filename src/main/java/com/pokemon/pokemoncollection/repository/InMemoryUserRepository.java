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
    }

    @Override
    public User findByEmail(String email) {
        for (User user : users) {
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }
}

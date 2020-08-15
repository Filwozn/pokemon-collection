package com.pokemon.pokemoncollection.service.register;

import com.pokemon.pokemoncollection.model.User;
import com.pokemon.pokemoncollection.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(userName);
        if (user == null){
            throw new UsernameNotFoundException("Nie znaleziono użytkownika");
        }
        return user;
    }
}

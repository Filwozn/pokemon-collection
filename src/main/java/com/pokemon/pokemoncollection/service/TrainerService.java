package com.pokemon.pokemoncollection.service;

import com.pokemon.pokemoncollection.dto.TrainerDTO;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {
    public void addTrainer(TrainerDTO trainerDTO){
        validateName(trainerDTO.getName());
    }
    public void validateName(String name){
        if(name.isBlank()){
            throw new TrainerServiceException("Nie podano imienia");
        }
    }

}

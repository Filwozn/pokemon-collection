package com.pokemon.pokemoncollection.service;

import com.pokemon.pokemoncollection.dto.TrainerDTO;
import com.pokemon.pokemoncollection.model.Trainer;
import com.pokemon.pokemoncollection.repository.TrainerRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {
    private TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public void addTrainer(TrainerDTO trainerDTO){
        validateName(trainerDTO.getName());
        Trainer trainer = new Trainer(trainerDTO.getName(), trainerDTO.getType());
        trainerRepository.save(trainer);
    }
    public void validateName(String name){
        if(name.isBlank()){
            throw new TrainerServiceException("Nie podano imienia");
        }
    }

}

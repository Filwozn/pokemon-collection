package com.pokemon.pokemoncollection.repository;

import com.pokemon.pokemoncollection.model.Trainer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class InMemoryTrainerRepository implements TrainerRepository{
    private List<Trainer>trainers = new ArrayList<>();
    @Override
    public void save(Trainer trainer) {
        trainers.add(trainer);
    }

    @Override
    public Trainer findByMail(String email) {
        for(Trainer trainer : trainers){
            if(trainer.getEmail().equals(email)){
               return trainer;
            }
        }
        return null; //FIXME: Use optional
    }
}

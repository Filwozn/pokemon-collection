package com.pokemon.pokemoncollection.service;

import com.pokemon.pokemoncollection.dto.TrainerDTO;
import com.pokemon.pokemoncollection.model.Trainer;
import com.pokemon.pokemoncollection.repository.TrainerRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {
    private TrainerRepository trainerRepository;
    private LoginService loginService;

    public TrainerService(TrainerRepository trainerRepository, LoginService loginService) {
        this.trainerRepository = trainerRepository;
        this.loginService = loginService;
    }

    public void addTrainer(TrainerDTO trainerDTO){
        validateUserHasNoTrainer();
        validateName(trainerDTO.getName());
        Trainer trainer = new Trainer(
                trainerDTO.getName(),
                trainerDTO.getType(),
                loginService.getLoggerUserMail());
        trainerRepository.save(trainer);
    }
    public void validateName(String name){
        if(name.isBlank()){
            throw new TrainerServiceException("Nie podano imienia");
        }
    }
    public void validateUserHasNoTrainer(){
        if(trainerRepository.findByMail(loginService.getLoggerUserMail()) !=null){
            throw new TrainerServiceException("Posiadasz już trenera");
        }
    }

}

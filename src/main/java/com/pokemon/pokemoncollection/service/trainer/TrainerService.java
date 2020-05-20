package com.pokemon.pokemoncollection.service.trainer;

import com.pokemon.pokemoncollection.dto.TrainerDTO;
import com.pokemon.pokemoncollection.model.Trainer;
import com.pokemon.pokemoncollection.repository.TrainerRepository;
import com.pokemon.pokemoncollection.service.login.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TrainerService {
    private TrainerRepository trainerRepository;
    private LoginService loginService;

    public TrainerService(TrainerRepository trainerRepository, LoginService loginService) {
        this.trainerRepository = trainerRepository;
        this.loginService = loginService;
    }

    @PostConstruct
    public void addTestTrainer(){
        Trainer trainer = new Trainer("Paula", "ognisty", "test@test.pl");
        trainerRepository.save(trainer);
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

    public Trainer getLoggedTrainer(){
        loginService.validateUserLogged();
        String email = loginService.getLoggerUserMail();
        Trainer trainer = trainerRepository.findByMail(email);
        if(trainer == null){
            throw new TrainerServiceException("Stwórz trenera");
        }
        return trainer;
    }

}

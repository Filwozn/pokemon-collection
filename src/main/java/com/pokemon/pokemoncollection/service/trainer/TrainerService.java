package com.pokemon.pokemoncollection.service.trainer;

import com.pokemon.pokemoncollection.dto.TrainerDTO;
import com.pokemon.pokemoncollection.model.Trainer;
import com.pokemon.pokemoncollection.repository.TrainerRepository;
import com.pokemon.pokemoncollection.service.login.LoginService;
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
    //Ta metoda upewnia się czy użtkownik jest zalogowany (wyrzuca wyjątek jesli niezalogowany), jesli tak to pobiera email
    //Wyszukujemy trenera po emailu
    //Jesli trenera nie ma to rzucamy wyjątek, na koniec zwracamy trenera
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

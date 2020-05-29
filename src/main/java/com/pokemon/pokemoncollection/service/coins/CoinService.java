package com.pokemon.pokemoncollection.service.coins;

import com.pokemon.pokemoncollection.model.Trainer;
import com.pokemon.pokemoncollection.repository.TrainerRepository;
import com.pokemon.pokemoncollection.service.trainer.TrainerService;
import org.springframework.stereotype.Service;

@Service
public class CoinService {
    private TrainerService trainerService;
    private TrainerRepository trainerRepository;
    public CoinService(TrainerService trainerService, TrainerRepository trainerRepository) {
        this.trainerService = trainerService;
        this.trainerRepository = trainerRepository;
    }

    public void addCoins(int coins){
        Trainer trainer = trainerService.getLoggedTrainer();
        trainer.addCoins(coins);
        trainerRepository.save(trainer);
    }
}

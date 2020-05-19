package com.pokemon.pokemoncollection.service.pack;

import com.pokemon.pokemoncollection.model.Card;
import com.pokemon.pokemoncollection.model.Trainer;
import com.pokemon.pokemoncollection.service.trainer.TrainerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PackService {
    private TrainerService trainerService;
    private PackOpener packOpener;

    public PackService(TrainerService trainerService, PackOpener packOpener) {
        this.trainerService = trainerService;
        this.packOpener = packOpener;
    }
    public List<Card> openPack(){
        Trainer trainer = trainerService.getLoggedTrainer();
        List<Card> pack = packOpener.generatePack();
        trainer.addPack(pack);
        return pack;
    }

}

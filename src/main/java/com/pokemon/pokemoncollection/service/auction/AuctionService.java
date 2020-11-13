package com.pokemon.pokemoncollection.service.auction;

import com.pokemon.pokemoncollection.model.Card;
import com.pokemon.pokemoncollection.model.Trainer;
import com.pokemon.pokemoncollection.repository.DataBaseCardRepository;
import com.pokemon.pokemoncollection.service.trainer.TrainerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService {
    private TrainerService trainerService;
    private DataBaseCardRepository dataBaseCardRepository;

    public AuctionService(TrainerService trainerService, DataBaseCardRepository dataBaseCardRepository) {
        this.trainerService = trainerService;
        this.dataBaseCardRepository = dataBaseCardRepository;
    }

    //int
    public int howManySameIdCard(String id) {
        //znajdz karte po ID
        Card card = findCardById(id);
        //sprawdz ile trener ma sztuk danej karty
        Trainer trainer = trainerService.getLoggedTrainer();
        return trainer.getCardAmount(card);
    }
    public Card findCardById(String id){
        return dataBaseCardRepository.findById(id).orElseThrow(()->new AuctionServiceException("Taka karta nie istnieje."));
    }

    public void sellCards(String id, int requestedAmount, int price) {
        int ownedAmount = howManySameIdCard(id);
        if (requestedAmount > ownedAmount) {
            throw new AuctionServiceException("Nie posiadasz tylu kart");
        }else if(requestedAmount < 1){
            throw new AuctionServiceException("Nie możesz sprzedać zero kart lub mniej");
        }
        if (price < 0){
            throw new AuctionServiceException("Minusowa cena!");
        }
        Trainer trainer = trainerService.getLoggedTrainer();
        Card card = findCardById(id);
        trainer.removeCard(card, requestedAmount);
        trainerService.saveTrainer(trainer);
    }

}

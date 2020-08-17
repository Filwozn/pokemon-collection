package com.pokemon.pokemoncollection.service.auction;

import com.pokemon.pokemoncollection.model.Card;
import com.pokemon.pokemoncollection.model.Trainer;
import com.pokemon.pokemoncollection.service.trainer.TrainerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuctionService {
    private TrainerService trainerService;

    public AuctionService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    public List<Card> findOwnedCardsById(String id) {
        Trainer trainer = trainerService.getLoggedTrainer();
        List<Card> ownedCards = trainer.getCards();
        List<Card> correctCards = new ArrayList<>();
        for (Card card : ownedCards) {
            if (id.equals(card.getId())) {
                correctCards.add(card);
            }
        }
        return correctCards;
    }
}

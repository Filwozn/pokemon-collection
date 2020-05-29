package com.pokemon.pokemoncollection.service.pack;

import com.pokemon.pokemoncollection.model.Card;
import com.pokemon.pokemoncollection.repository.DataBaseCardRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class PackOpener {
    private DataBaseCardRepository cardRepository;

    public PackOpener(DataBaseCardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> generatePack() {
        List<Card> allCards = cardRepository.findAll();
        Random random = new Random();
        List<Card> pack = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int cardIndex = random.nextInt(allCards.size());
            Card card = allCards.get(cardIndex);
            pack.add(card);
        }
        return pack;
    }
}

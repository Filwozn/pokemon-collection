package com.pokemon.pokemoncollection.service.pack;

import com.pokemon.pokemoncollection.model.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class PackOpener {
    private String[] cards = {"pokemon1", "pokemon2,", "pokemon3", "pokemon4", "pokemon5"};

    public List<Card> generatePack() {
        Random random = new Random();
        List<Card> pack = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int cardIndex = random.nextInt(cards.length);
            Card card = new Card(cards[cardIndex]);
            pack.add(card);
        }
        return pack;
    }
}

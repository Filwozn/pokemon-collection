package com.pokemon.pokemoncollection.service.pack;

import com.pokemon.pokemoncollection.client.PokemonTCGApiClient;
import com.pokemon.pokemoncollection.model.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class PackOpener {
    private PokemonTCGApiClient downloadClient;

    public PackOpener(PokemonTCGApiClient downloadClient) {
        this.downloadClient = downloadClient;
    }

    public List<Card> generatePack() {
        List<Card> allCards = downloadClient.downloadCards();
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

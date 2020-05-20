package com.pokemon.pokemoncollection.client;

import com.pokemon.pokemoncollection.model.Card;
import com.pokemon.pokemoncollection.model.Cards;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PokemonTCGApiClient {
    private static final String POKEMON_TCG_API_LINK = "https://api.pokemontcg.io/v1/cards";
    private RestTemplate restTemplate;

    public PokemonTCGApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<Card> downloadCards(){
     Cards cardsObject = restTemplate.getForObject(POKEMON_TCG_API_LINK, Cards.class);
     if(cardsObject == null){
         return new ArrayList<>();
     }
     return cardsObject.getCards();
    }
}

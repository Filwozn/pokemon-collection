package com.pokemon.pokemoncollection.client;

import com.pokemon.pokemoncollection.model.Card;
import com.pokemon.pokemoncollection.model.Cards;
import com.pokemon.pokemoncollection.repository.DataBaseCardRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class PokemonTCGApiClient {
    private static final String POKEMON_TCG_API_LINK = "https://api.pokemontcg.io/v1/cards";
    private RestTemplate restTemplate;
    private DataBaseCardRepository cardRepository;

    public PokemonTCGApiClient(RestTemplate restTemplate, DataBaseCardRepository cardRepository) {
        this.restTemplate = restTemplate;
        this.cardRepository = cardRepository;
    }

    @PostConstruct
    public void fillDataBase(){
        List<Card> cards = downloadCards();
        cardRepository.saveAll(cards);
    }

    public List<Card> downloadCards(){
     Cards cardsObject = restTemplate.getForObject(POKEMON_TCG_API_LINK, Cards.class);
     if(cardsObject == null){
         return new ArrayList<>();
     }
     return cardsObject.getCards();
    }
}

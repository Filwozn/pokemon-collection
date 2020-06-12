package com.pokemon.pokemoncollection.client;

import com.pokemon.pokemoncollection.client.tamplates.AllSets;
import com.pokemon.pokemoncollection.model.Card;
import com.pokemon.pokemoncollection.model.Cards;
import com.pokemon.pokemoncollection.model.Set;
import com.pokemon.pokemoncollection.repository.DataBaseCardRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.expression.Sets;

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
    @PostConstruct
    public void downloadSets(){
       AllSets allSets = restTemplate.getForObject("https://pokemontcg.io/sets", AllSets.class);
        System.out.println(allSets);
    }

    private List<Card> downloadCards(){
     Cards cardsObject = restTemplate.getForObject(POKEMON_TCG_API_LINK, Cards.class);
     if(cardsObject == null){
         return new ArrayList<>();
     }
     return cardsObject.getCards();
    }
}

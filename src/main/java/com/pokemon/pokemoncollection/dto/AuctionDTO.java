package com.pokemon.pokemoncollection.dto;

import com.pokemon.pokemoncollection.model.Card;
import com.pokemon.pokemoncollection.model.Trainer;
import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Builder
public class AuctionDTO {
    private String cardURL;
    private int price;
    private int cardAmount;
    private String sellerName;
    private int auctionId;
}

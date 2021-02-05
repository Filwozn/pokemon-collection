package com.pokemon.pokemoncollection.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuctionRequest {
    private int auctionId;
    private int cardAmount;

}

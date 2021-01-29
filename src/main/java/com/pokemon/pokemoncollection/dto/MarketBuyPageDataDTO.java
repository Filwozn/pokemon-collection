package com.pokemon.pokemoncollection.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MarketBuyPageDataDTO {
  private List<AuctionDTO> auctions;
  private int ownedCoins;
}

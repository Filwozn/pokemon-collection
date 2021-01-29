package com.pokemon.pokemoncollection.service.auction;

import com.pokemon.pokemoncollection.dto.AuctionDTO;
import com.pokemon.pokemoncollection.dto.MarketBuyPageDataDTO;
import com.pokemon.pokemoncollection.model.Auction;
import com.pokemon.pokemoncollection.model.Card;
import com.pokemon.pokemoncollection.model.Trainer;
import com.pokemon.pokemoncollection.repository.AuctionRepository;
import com.pokemon.pokemoncollection.repository.DataBaseCardRepository;
import com.pokemon.pokemoncollection.service.trainer.TrainerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuctionService {
    private TrainerService trainerService;
    private DataBaseCardRepository dataBaseCardRepository;
    private AuctionRepository auctionRepository;

    public AuctionService(TrainerService trainerService, DataBaseCardRepository dataBaseCardRepository, AuctionRepository auctionRepository) {
        this.trainerService = trainerService;
        this.dataBaseCardRepository = dataBaseCardRepository;
        this.auctionRepository = auctionRepository;
    }

    //int
    public int howManySameIdCard(String id) {
        //znajdz karte po ID
        Card card = findCardById(id);
        //sprawdz ile trener ma sztuk danej karty
        Trainer trainer = trainerService.getLoggedTrainer();
        return trainer.getCardAmount(card);
    }

    public Card findCardById(String id) {
        return dataBaseCardRepository.findById(id).orElseThrow(() -> new AuctionServiceException("Taka karta nie istnieje."));
    }

    public void sellCards(String id, int requestedAmount, int price) {
        int ownedAmount = howManySameIdCard(id);
        if (requestedAmount > ownedAmount) {
            throw new AuctionServiceException("Nie posiadasz tylu kart");
        } else if (requestedAmount < 1) {
            throw new AuctionServiceException("Nie możesz sprzedać zero kart lub mniej");
        }
        if (price < 0) {
            throw new AuctionServiceException("Minusowa cena!");
        }
        Trainer trainer = trainerService.getLoggedTrainer();
        Card card = findCardById(id);
        trainer.removeCard(card, requestedAmount);
        trainerService.saveTrainer(trainer);
        Auction auction = new Auction(card, price, requestedAmount, trainer);
        auctionRepository.save(auction);
    }

    public MarketBuyPageDataDTO buildMarketBuyPageData() {
        List<Auction> auctionList = auctionRepository.findAll();
        int ownedCoins = trainerService.getLoggedTrainer().getCoins();
        List<AuctionDTO> auctionDTOs = new ArrayList<>();
        for (Auction auction : auctionList) {
          AuctionDTO auctionDTO = AuctionDTO.builder()
                    .auctionId(auction.getId())
                    .cardAmount(auction.getCardAmount())
                    .cardURL(auction.getCard().getImageUrl())
                    .price(auction.getPrice())
                    .sellerName(auction.getSeller().getName())
                    .build();
          auctionDTOs.add(auctionDTO);
        }
        return MarketBuyPageDataDTO.builder()
                .auctions(auctionDTOs)
                .ownedCoins(ownedCoins)
                .build();
    }

}

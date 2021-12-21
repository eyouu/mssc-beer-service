package com.whosaidmeow.msscbeerservice.services;

import com.whosaidmeow.common.events.BeerDTO;
import com.whosaidmeow.msscbeerservice.web.model.BeerPagedList;
import com.whosaidmeow.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {
    BeerDTO getById(UUID beerId, Boolean showInventoryOnHand);

    BeerDTO getByUpc(String upc);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    BeerDTO updateBeer(UUID beerId, BeerDTO beerDTO);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, Boolean showInventoryOnHand, PageRequest pageRequest);
}

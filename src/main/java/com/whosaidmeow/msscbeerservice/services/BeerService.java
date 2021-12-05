package com.whosaidmeow.msscbeerservice.services;

import com.whosaidmeow.msscbeerservice.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getById(UUID beerId);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    BeerDTO updateBeer(UUID beerId, BeerDTO beerDTO);
}

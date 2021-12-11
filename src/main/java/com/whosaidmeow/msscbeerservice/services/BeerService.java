package com.whosaidmeow.msscbeerservice.services;

import com.whosaidmeow.msscbeerservice.web.model.BeerDTO;
import com.whosaidmeow.msscbeerservice.web.model.BeerPagedList;
import com.whosaidmeow.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {
    BeerDTO getById(UUID beerId);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    BeerDTO updateBeer(UUID beerId, BeerDTO beerDTO);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest);
}

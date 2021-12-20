package com.whosaidmeow.msscbeerservice.events;

import com.whosaidmeow.msscbeerservice.web.model.BeerDTO;

public class BrewBeerEvent extends BeerEvent {
    public BrewBeerEvent(BeerDTO beerDTO) {
        super(beerDTO);
    }
}

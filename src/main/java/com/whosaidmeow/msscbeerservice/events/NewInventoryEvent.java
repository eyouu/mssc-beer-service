package com.whosaidmeow.msscbeerservice.events;

import com.whosaidmeow.msscbeerservice.web.model.BeerDTO;

public class NewInventoryEvent extends BeerEvent {
    public NewInventoryEvent(BeerDTO beerDTO) {
        super(beerDTO);
    }
}

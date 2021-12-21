package com.whosaidmeow.common.events;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent {
    public BrewBeerEvent(BeerDTO beerDTO) {
        super(beerDTO);
    }
}

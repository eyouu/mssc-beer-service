package com.whosaidmeow.common.events;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {
    public NewInventoryEvent(BeerDTO beerDTO) {
        super(beerDTO);
    }
}

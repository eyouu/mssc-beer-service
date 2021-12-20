package com.whosaidmeow.msscbeerservice.events;

import com.whosaidmeow.msscbeerservice.web.model.BeerDTO;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
@Data
@Builder
public class BeerEvent implements Serializable {

    static final long serialVersionUID = 3988545114367772700L;

    private final BeerDTO beerDTO;
}

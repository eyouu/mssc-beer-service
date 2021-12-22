package com.whosaidmeow.msscbeerservice.services.order;

import com.whosaidmeow.brewery.model.BeerOrderDTO;
import com.whosaidmeow.msscbeerservice.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@RequiredArgsConstructor
public class BeerOrderValidator {

    private BeerRepository beerRepository;

    public Boolean validateOrder(BeerOrderDTO beerOrderDTO) {
        AtomicInteger beersNotFound = new AtomicInteger();

        beerOrderDTO.getBeerOrderLines().forEach(orderLine -> {
            if (beerRepository.findByUpc(orderLine.getUpc()) == null) {
                beersNotFound.incrementAndGet();
            }
        });

        return beersNotFound.get() == 0;
    }
}

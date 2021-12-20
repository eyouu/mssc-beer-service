package com.whosaidmeow.msscbeerservice.services.brewing;

import com.whosaidmeow.msscbeerservice.domain.Beer;
import com.whosaidmeow.msscbeerservice.events.BrewBeerEvent;
import com.whosaidmeow.msscbeerservice.events.NewInventoryEvent;
import com.whosaidmeow.msscbeerservice.repository.BeerRepository;
import com.whosaidmeow.msscbeerservice.web.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import static com.whosaidmeow.msscbeerservice.config.JmsConfig.BREWING_REQUEST_QUEUE;
import static com.whosaidmeow.msscbeerservice.config.JmsConfig.NEW_INVENTORY_QUEUE;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewBeerListener {

    private final JmsTemplate jmsTemplate;
    private final BeerRepository beerRepository;

    @JmsListener(destination = BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent brewBeerEvent) {
        BeerDTO beerDTO = brewBeerEvent.getBeerDTO();

        Beer beer = beerRepository.getById(beerDTO.getId());
        beerDTO.setQualityOnHand(beer.getQuantityToBrew());

        log.debug("Brewed beer: {} : QOH: {}", beer.getMinOnHand(), beerDTO.getQualityOnHand());

        jmsTemplate.convertAndSend(NEW_INVENTORY_QUEUE, new NewInventoryEvent(beerDTO));
    }
}

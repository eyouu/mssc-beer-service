package com.whosaidmeow.msscbeerservice.services;

import com.whosaidmeow.msscbeerservice.domain.Beer;
import com.whosaidmeow.msscbeerservice.events.BrewBeerEvent;
import com.whosaidmeow.msscbeerservice.repository.BeerRepository;
import com.whosaidmeow.msscbeerservice.services.inventory.BeerInventoryService;
import com.whosaidmeow.msscbeerservice.web.mapper.BeerMapper;
import com.whosaidmeow.msscbeerservice.web.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.whosaidmeow.msscbeerservice.config.JmsConfig.BREWING_REQUEST_QUEUE;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {

    private final BeerMapper beerMapper;
    private final JmsTemplate jmsTemplate;
    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;

    @Scheduled(fixedRate = 5000) // every 5 seconds
    public void checkForLowInventory() {
        List<Beer> beers = beerRepository.findAll();

        beers.forEach(beer -> {
            Integer invQOH = beerInventoryService.getOnHandInventory(beer.getId());

            log.debug("Min on hand is: {}", beer.getMinOnHand());
            log.debug("Inventory is: {}", invQOH);

            if (beer.getMinOnHand() >= invQOH) {
                BeerDTO beerDTO = beerMapper.beerToBeerDTO(beer);

                jmsTemplate.convertAndSend(BREWING_REQUEST_QUEUE, new BrewBeerEvent(beerDTO));
            }
        });
    }
}

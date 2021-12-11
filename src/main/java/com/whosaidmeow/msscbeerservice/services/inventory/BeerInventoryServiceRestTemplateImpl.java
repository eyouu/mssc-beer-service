package com.whosaidmeow.msscbeerservice.services.inventory;

import com.whosaidmeow.msscbeerservice.services.inventory.model.BeerInventoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Slf4j
@Component
public class BeerInventoryServiceRestTemplateImpl implements BeerInventoryService {

    private static final String INVENTORY_PATH = "/api/v1/beer/{beerId}/inventory";

    @Value("${com.whosaidmeow.inventoryservice.host}")
    private String beerInventoryServiceHost;

    private final RestTemplate restTemplate;

    public BeerInventoryServiceRestTemplateImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Integer getOnHandInventory(UUID beerId) {
        log.debug("Calling Inventory Service");

        ResponseEntity<List<BeerInventoryDTO>> responseEntity = restTemplate.exchange(
                beerInventoryServiceHost + INVENTORY_PATH,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {},
                beerId);

        return requireNonNull(responseEntity.getBody()).stream()
                .mapToInt(BeerInventoryDTO::getQuantityOnHand)
                .sum();
    }
}

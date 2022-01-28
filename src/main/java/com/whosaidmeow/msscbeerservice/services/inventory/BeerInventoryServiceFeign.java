package com.whosaidmeow.msscbeerservice.services.inventory;

import com.whosaidmeow.msscbeerservice.services.inventory.model.BeerInventoryDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Profile("local-discovery")
@Slf4j
@RequiredArgsConstructor
@Service
public class BeerInventoryServiceFeign implements BeerInventoryService {

    private final InventoryServiceFeignClient inventoryServiceFeignClient;

    @Override
    public Integer getOnHandInventory(UUID beerId) {
        log.debug("Finding inventory for beer: {}", beerId);

        ResponseEntity<List<BeerInventoryDTO>> onHandInventory = inventoryServiceFeignClient.getOnHandInventory(beerId);

        int sum = Objects.requireNonNull(onHandInventory.getBody()).stream()
                .mapToInt(BeerInventoryDTO::getQuantityOnHand)
                .sum();

        log.debug("Available quantity for beer: {} is: {}", beerId, sum);

        return sum;
    }
}

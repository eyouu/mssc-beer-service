package com.whosaidmeow.msscbeerservice.services.inventory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerInventoryServiceRestTemplateImplTest {

    @Autowired
    private BeerInventoryService beerInventoryService;

    void shouldGetOnHandInventory() {
        Integer onHandInventory = beerInventoryService.getOnHandInventory(UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb"));

        System.out.println(onHandInventory);
    }
}
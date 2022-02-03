package com.whosaidmeow.msscbeerservice.services.inventory;

import com.whosaidmeow.msscbeerservice.services.inventory.model.BeerInventoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;
// fallback -> implementation of case when /inventory-failover is called.
@FeignClient(name = "inventory-service", fallback = InventoryServiceFeignClientFailover.class)
public interface InventoryServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET, path = BeerInventoryServiceRestTemplateImpl.INVENTORY_PATH)
    ResponseEntity<List<BeerInventoryDTO>> getOnHandInventory(@PathVariable UUID beerId);
}

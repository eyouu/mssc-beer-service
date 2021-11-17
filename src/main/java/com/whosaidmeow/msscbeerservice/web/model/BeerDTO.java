package com.whosaidmeow.msscbeerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {

    private UUID id;
    private Long upc;
    private String beerName;
    private Integer version;
    private BigDecimal price;
    private Integer qualityOnHand;
    private BeerStyleEnum beerStyleEnum;

    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;
}

package com.whosaidmeow.msscbeerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {

    @Null
    private UUID id;

    @NotNull
    @Positive
    private Long upc;

    @NotBlank
    private String beerName;

    @Null
    private Integer version;

    @NotNull
    @Positive
    private BigDecimal price;
    private Integer qualityOnHand;

    @NotNull
    private BeerStyleEnum beerStyleEnum;

    @Null
    private OffsetDateTime createdDate;

    @Null
    private OffsetDateTime lastModifiedDate;
}

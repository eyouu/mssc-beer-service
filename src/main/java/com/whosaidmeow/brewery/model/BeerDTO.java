package com.whosaidmeow.brewery.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.whosaidmeow.brewery.model.BeerStyleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO implements Serializable {

    static final long serialVersionUID = 3154644511142259256L;

    @Null
    private UUID id;

    @NotNull
    private String upc;

    @NotBlank
    private String beerName;

    @Null
    private Integer version;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull
    @Positive
    private BigDecimal price;
    private Integer qualityOnHand;

    @NotNull
    private BeerStyleEnum beerStyle;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    @Null
    private OffsetDateTime createdDate;

    @Null
    private OffsetDateTime lastModifiedDate;
}

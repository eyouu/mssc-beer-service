package com.whosaidmeow.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whosaidmeow.msscbeerservice.bootstrap.BeerLoader;
import com.whosaidmeow.msscbeerservice.services.BeerService;
import com.whosaidmeow.msscbeerservice.web.model.BeerDTO;
import com.whosaidmeow.msscbeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BeerService beerService;

    @Test
    void getBeerById() throws Exception {
        given(beerService.getById(any())).willReturn(getBeerDTO());

        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        given(beerService.saveNewBeer(any())).willReturn(getBeerDTO());

        BeerDTO beerDTO = getBeerDTO();
        String beerDTOJson = objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(post("/api/v1/beer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDTOJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        given(beerService.updateBeer(any(), any())).willReturn(getBeerDTO());

        BeerDTO beerDTO = getBeerDTO();
        String beerDTOJson = objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDTOJson))
                .andExpect(status().isNoContent());
    }

    private BeerDTO getBeerDTO() {
        return BeerDTO.builder()
                .beerName("My beer")
                .beerStyle(BeerStyleEnum.GOSE)
                .price(new BigDecimal("2.44"))
                .upc(BeerLoader.BEER_1_UPC)
                .build();
    }
}
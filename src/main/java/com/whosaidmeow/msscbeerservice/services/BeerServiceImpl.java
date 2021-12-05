package com.whosaidmeow.msscbeerservice.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whosaidmeow.msscbeerservice.domain.Beer;
import com.whosaidmeow.msscbeerservice.repository.BeerRepository;
import com.whosaidmeow.msscbeerservice.web.controller.NotFoundException;
import com.whosaidmeow.msscbeerservice.web.mapper.BeerMapper;
import com.whosaidmeow.msscbeerservice.web.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerMapper beerMapper;
    private final BeerRepository beerRepository;

    @Override
    public BeerDTO getById(UUID beerId) {
        return beerMapper.beerToBeerDTO(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beerDTO) {
        return beerMapper.beerToBeerDTO(beerRepository.save(beerMapper.beerDTOToBeer(beerDTO)));
    }

    @Override
    public BeerDTO updateBeer(UUID beerId, BeerDTO beerDTO) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDTO.getBeerName());
        beer.setBeerStyle(beerDTO.getBeerStyle().name());
        beer.setPrice(beerDTO.getPrice());
        beer.setUpc(beer.getUpc());

        return beerMapper.beerToBeerDTO(beerRepository.save(beer));
    }
}

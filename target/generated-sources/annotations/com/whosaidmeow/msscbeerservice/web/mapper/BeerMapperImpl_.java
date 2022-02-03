package com.whosaidmeow.msscbeerservice.web.mapper;

import com.whosaidmeow.brewery.model.BeerDTO;
import com.whosaidmeow.brewery.model.BeerDTO.BeerDTOBuilder;
import com.whosaidmeow.brewery.model.BeerStyleEnum;
import com.whosaidmeow.msscbeerservice.domain.Beer;
import com.whosaidmeow.msscbeerservice.domain.Beer.BeerBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-03T17:08:56+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
@Qualifier("delegate")
public class BeerMapperImpl_ implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerDTO beerToBeerDTO(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDTOBuilder beerDTO = BeerDTO.builder();

        beerDTO.id( beer.getId() );
        beerDTO.upc( beer.getUpc() );
        beerDTO.beerName( beer.getBeerName() );
        if ( beer.getVersion() != null ) {
            beerDTO.version( beer.getVersion().intValue() );
        }
        beerDTO.price( beer.getPrice() );
        if ( beer.getBeerStyle() != null ) {
            beerDTO.beerStyle( Enum.valueOf( BeerStyleEnum.class, beer.getBeerStyle() ) );
        }
        beerDTO.createdDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDTO.lastModifiedDate( dateMapper.asOffsetDateTime( beer.getLastModifiedDate() ) );

        return beerDTO.build();
    }

    @Override
    public BeerDTO beerToBeerDTOWithInventory(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDTOBuilder beerDTO = BeerDTO.builder();

        beerDTO.id( beer.getId() );
        beerDTO.upc( beer.getUpc() );
        beerDTO.beerName( beer.getBeerName() );
        if ( beer.getVersion() != null ) {
            beerDTO.version( beer.getVersion().intValue() );
        }
        beerDTO.price( beer.getPrice() );
        if ( beer.getBeerStyle() != null ) {
            beerDTO.beerStyle( Enum.valueOf( BeerStyleEnum.class, beer.getBeerStyle() ) );
        }
        beerDTO.createdDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDTO.lastModifiedDate( dateMapper.asOffsetDateTime( beer.getLastModifiedDate() ) );

        return beerDTO.build();
    }

    @Override
    public Beer beerDTOToBeer(BeerDTO beerDTO) {
        if ( beerDTO == null ) {
            return null;
        }

        BeerBuilder beer = Beer.builder();

        beer.id( beerDTO.getId() );
        if ( beerDTO.getVersion() != null ) {
            beer.version( beerDTO.getVersion().longValue() );
        }
        beer.createdDate( dateMapper.asTimestamp( beerDTO.getCreatedDate() ) );
        beer.lastModifiedDate( dateMapper.asTimestamp( beerDTO.getLastModifiedDate() ) );
        beer.beerName( beerDTO.getBeerName() );
        if ( beerDTO.getBeerStyle() != null ) {
            beer.beerStyle( beerDTO.getBeerStyle().name() );
        }
        beer.upc( beerDTO.getUpc() );
        beer.price( beerDTO.getPrice() );

        return beer.build();
    }
}

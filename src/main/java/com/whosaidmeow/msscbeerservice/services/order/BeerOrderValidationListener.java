package com.whosaidmeow.msscbeerservice.services.order;

import com.whosaidmeow.brewery.model.events.ValidateOrderRequestEvent;
import com.whosaidmeow.brewery.model.events.ValidateOrderResultEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import static com.whosaidmeow.msscbeerservice.config.JmsConfig.VALIDATE_ORDER_QUEUE;
import static com.whosaidmeow.msscbeerservice.config.JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE;

@Component
@RequiredArgsConstructor
public class BeerOrderValidationListener {

    private final JmsTemplate jmsTemplate;
    private final BeerOrderValidator beerOrderValidator;

    @JmsListener(destination = VALIDATE_ORDER_QUEUE)
    public void listen(ValidateOrderRequestEvent event) {
        Boolean isValid = beerOrderValidator.validateOrder(event.getBeerOrderDTO());

        jmsTemplate.convertAndSend(VALIDATE_ORDER_RESPONSE_QUEUE, ValidateOrderResultEvent.builder()
                .orderId(event.getBeerOrderDTO().getId())
                .isValid(isValid));
    }
}

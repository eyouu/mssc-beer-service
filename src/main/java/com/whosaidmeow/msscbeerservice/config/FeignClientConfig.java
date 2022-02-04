package com.whosaidmeow.msscbeerservice.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    // Interceptor that does authentication for Feign Client calls
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(@Value("${com.whosaidmeow.inventoryservice.password}") String inventoryUser,
                                                                   @Value("${com.whosaidmeow.inventoryservice.password}") String inventoryPassword) {
        return new BasicAuthRequestInterceptor(inventoryUser, inventoryPassword);
    }
}

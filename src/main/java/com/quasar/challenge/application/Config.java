package com.quasar.challenge.application;

import com.quasar.challenge.config.SpringConfig;
import com.quasar.challenge.usecases.GetLocation;
import com.quasar.challenge.usecases.GetMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private final SpringConfig config = new SpringConfig();

    @Bean
    public GetLocation getLocation() {
        return config.getLocation();
    }

    @Bean
    public GetMessage getMessage() {
        return config.getMessage();
    }
}

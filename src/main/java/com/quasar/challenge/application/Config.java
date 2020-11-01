package com.quasar.challenge.application;

import com.quasar.challenge.config.SpringConfig;
import com.quasar.challenge.infraestructure.delivery.services.QuasarService;
import com.quasar.challenge.usecases.GetLocationUseCase;
import com.quasar.challenge.usecases.GetMessageUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private final SpringConfig config = new SpringConfig();

    @Bean
    public GetLocationUseCase getLocation() {
        return config.getLocation();
    }

    @Bean
    public GetMessageUseCase getMessage() {
        return config.getMessage();
    }

    @Bean
    public QuasarService topSecret() { return config.topSecret(); }
}

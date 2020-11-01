package com.quasar.challenge.config;

import com.quasar.challenge.adapter.repository.InMemoryCoordinateRepository;
import com.quasar.challenge.infraestructure.delivery.services.QuasarService;
import com.quasar.challenge.usecases.GetLocationUseCase;
import com.quasar.challenge.usecases.GetMessageUseCase;

public class SpringConfig {

    private final InMemoryCoordinateRepository coordinateRepository = new InMemoryCoordinateRepository();

    public GetLocationUseCase getLocation() {
        return new GetLocationUseCase(coordinateRepository);
    }

    public GetMessageUseCase getMessage() {
        return new GetMessageUseCase();
    }

    public QuasarService topSecret() { return new QuasarService(getLocation(), getMessage()); }
}

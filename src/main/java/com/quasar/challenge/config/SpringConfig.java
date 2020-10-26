package com.quasar.challenge.config;

import com.quasar.challenge.adapter.repository.InMemoryCoordinateRepository;
import com.quasar.challenge.usecases.GetLocation;
import com.quasar.challenge.usecases.GetMessage;

public class SpringConfig {

    private final InMemoryCoordinateRepository coordinateRepository = new InMemoryCoordinateRepository();

    public GetLocation getLocation() {
        return new GetLocation(coordinateRepository);
    }

    public GetMessage getMessage() {
        return new GetMessage();
    }
}

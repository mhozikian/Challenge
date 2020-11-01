package com.quasar.challenge.infraestructure.delivery.services;

import com.quasar.challenge.domain.entity.Coordinate;
import com.quasar.challenge.infraestructure.model.dto.SOSMessageDTO;
import com.quasar.challenge.infraestructure.model.dto.SatelliteDTO;
import com.quasar.challenge.usecases.GetLocationUseCase;
import com.quasar.challenge.usecases.GetMessageUseCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class QuasarService {
    private final GetLocationUseCase getLocation;
    private final GetMessageUseCase getMessage;

    public QuasarService(GetLocationUseCase getLocation,
                         GetMessageUseCase getMessage) {
        this.getLocation = getLocation;
        this.getMessage = getMessage;
    }

    public Optional<SOSMessageDTO> topSecret(Collection<SatelliteDTO> satellites){
        SOSMessageDTO sosMessageDTO = new SOSMessageDTO();
        try {
            Coordinate c = getLocation.getLocation(satellites.stream().map(
                    d -> d.getDistance()).collect(toList()));

            String s = getMessage.getMessage(satellites.stream().map(
                    m -> new ArrayList<>(Arrays.asList(m.getMessage()))).collect(toList()));
            sosMessageDTO.setPosition(c);
            sosMessageDTO.setMessage(s);
            return Optional.of(sosMessageDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}

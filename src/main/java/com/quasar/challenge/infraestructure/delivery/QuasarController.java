package com.quasar.challenge.infraestructure.delivery;

import com.quasar.challenge.infraestructure.model.dto.SOSMessageDTO;
import com.quasar.challenge.infraestructure.model.dto.SatelliteDTO;
import com.quasar.challenge.infraestructure.shared.exceptions.QuasarException;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface QuasarController {
    public ResponseEntity<SOSMessageDTO> topSecret(Collection<SatelliteDTO> category) throws QuasarException;
}

package com.quasar.challenge.infraestructure.delivery.impl;

import com.quasar.challenge.domain.exception.NotIntersectionException;
import com.quasar.challenge.infraestructure.delivery.QuasarController;
import com.quasar.challenge.infraestructure.delivery.services.QuasarService;
import com.quasar.challenge.infraestructure.model.dto.SOSMessageDTO;
import com.quasar.challenge.infraestructure.model.dto.SatelliteDTO;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;

@RestController
@EnableAutoConfiguration
public class QuasarControllerImpl implements QuasarController {

    private final QuasarService quasarService;

    public QuasarControllerImpl(QuasarService quasarService) {
        this.quasarService = quasarService;
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/topsecret", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SOSMessageDTO> topSecret(@RequestBody Collection<SatelliteDTO> satellites){
        Optional<SOSMessageDTO> message = quasarService.topSecret(satellites);
        if (message.isPresent()) {
            return new ResponseEntity<SOSMessageDTO>(message.get(), HttpStatus.OK);
        }else{
             return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
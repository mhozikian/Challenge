package com.quasar.challenge.infraestructure.delivery.impl;

import com.quasar.challenge.infraestructure.delivery.QuasarController;
import com.quasar.challenge.infraestructure.delivery.responses.QuasarResponse;
import com.quasar.challenge.infraestructure.delivery.services.QuasarService;
import com.quasar.challenge.infraestructure.model.dto.SOSMessageDTO;
import com.quasar.challenge.infraestructure.model.dto.SatelliteDTO;
import com.quasar.challenge.infraestructure.model.dto.SatelliteMinDTO;
import com.quasar.challenge.infraestructure.shared.constants.Constants;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RestController
@EnableAutoConfiguration
public class QuasarControllerImpl implements QuasarController {

    private final QuasarService quasarService;
    /*Objeto que simula una sesion para poder enviar post de en servicios individuales
    con un satelite por post*/
    private final Collection<SatelliteDTO> simileSession = new ArrayList<>();

    public QuasarControllerImpl(QuasarService quasarService) {
        this.quasarService = quasarService;
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/topsecret", produces = MediaType.APPLICATION_JSON_VALUE)
    public QuasarResponse<SOSMessageDTO> topSecret(@RequestBody Collection<SatelliteDTO> satellites,
                                                    HttpServletResponse response) {
        Optional<SOSMessageDTO> message = quasarService.topSecret(satellites);
        return this.getResponse(message, response);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/topsecret_split",
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public QuasarResponse<SOSMessageDTO> topSecretSplit(@RequestParam(value = "name") String name,
                                                        @RequestBody SatelliteMinDTO satellite,
                                                        HttpServletResponse response) {
        /*Agrego un satelite a la lista de la 'sesion' para chequear que se cuenta con
        la informacion suficiente para realizar el calculo de triangulacion
        setSatelliteInSesion(satellite, name);*/
        SatelliteDTO satelliteSesion = new SatelliteDTO(name);
        satelliteSesion.setDistance(satellite.getDistance());
        satelliteSesion.setMessage(satellite.getMessage());
        simileSession.add(satelliteSesion);
        /*Si hay tres satelites cargados en sesion se puede determinar las coordenadas de la nave*/
        if (simileSession.size() == 3) {
            Optional<SOSMessageDTO> sosMessageDTO = quasarService.topSecret(simileSession);
            return this.getResponse(sosMessageDTO, response);
        /*Si no se cuenta con la informacion de tres satelites, no puede realizarse el calculo de triangulacion*/
        }else{
            return new QuasarResponse<>(Constants.CODE_HTTP_ERROR, Constants.NOT_ENOUGH_INFO, null);
        }
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/topsecret_split",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public QuasarResponse<SOSMessageDTO> topSecretSplit(HttpServletResponse response) {
        /*Si hay tres satelites cargados en sesion se puede determinar las coordenadas de la nave*/
        if (simileSession.size() == 3) {
            Optional<SOSMessageDTO> sosMessageDTO = quasarService.topSecret(simileSession);
            return this.getResponse(sosMessageDTO, response);
            /*Si no se cuenta con la informacion de tres satelites, no puede realizarse el calculo de triangulacion*/
        }else{
            return new QuasarResponse<>(Constants.CODE_HTTP_ERROR, Constants.NOT_POSITION_DETERMINATE, null);
        }
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/resetLocalMemory",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public QuasarResponse<SOSMessageDTO> resetLocalMemory(HttpServletResponse response) {
        this.simileSession.clear();
        return new QuasarResponse<>(Constants.CODE_HTTP_OK, Constants.OK_MEMORY_CLEAN, null);
    }

    /*Comportamiento comun entre los metodos de esta clase*/
    private QuasarResponse<SOSMessageDTO> getResponse(Optional<SOSMessageDTO> sosMessageDTO,
                                                      HttpServletResponse response){
        /*Si se obtiene un mensaje por parte del servicio, se retorna*/
        if (sosMessageDTO.isPresent()) {
            return new QuasarResponse<>(Constants.CODE_HTTP_OK, Constants.OK_SUCCESS, sosMessageDTO.get());
        /*Si el servicio no devuelve datos, el calculo tuvo una falla*/
        }else{
            return new QuasarResponse<>(Constants.CODE_HTTP_ERROR, Constants.NOT_POSITION_DETERMINATE, null);
        }
    }
}
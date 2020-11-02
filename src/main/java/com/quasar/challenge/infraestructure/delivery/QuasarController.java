package com.quasar.challenge.infraestructure.delivery;

import com.quasar.challenge.infraestructure.delivery.responses.QuasarResponse;
import com.quasar.challenge.infraestructure.model.dto.SOSMessageDTO;
import com.quasar.challenge.infraestructure.model.dto.SatelliteDTO;
import com.quasar.challenge.infraestructure.model.dto.SatelliteMinDTO;
import com.quasar.challenge.infraestructure.shared.exceptions.QuasarException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public interface QuasarController {
    QuasarResponse<SOSMessageDTO> topSecret(Collection<SatelliteDTO> category, HttpServletResponse response) throws QuasarException, IOException;
    QuasarResponse<SOSMessageDTO> topSecretSplit(String name, SatelliteMinDTO satellite, HttpServletResponse response) throws QuasarException, IOException;
    QuasarResponse<SOSMessageDTO> topSecretSplit(HttpServletResponse response) throws IOException;
    QuasarResponse<SOSMessageDTO> resetLocalMemory(HttpServletResponse response) throws IOException;
}

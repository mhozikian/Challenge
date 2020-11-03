package com.quasar.challenge.infraestructure.model.dto;

import com.quasar.challenge.domain.entity.Coordinate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SOSMessageDTO implements Serializable{

    private Coordinate position;
    private String message;

}

package com.quasar.challenge.infraestructure.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SatelliteDTO extends SatelliteMinDTO implements Serializable {

    private String name;

}

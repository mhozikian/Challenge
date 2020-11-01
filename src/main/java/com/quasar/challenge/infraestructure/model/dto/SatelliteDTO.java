package com.quasar.challenge.infraestructure.model.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class SatelliteDTO implements Serializable {

    private String name;
    private double distance;
    private String[] message;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance(){
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}

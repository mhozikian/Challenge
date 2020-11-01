package com.quasar.challenge.infraestructure.model.dto;

import com.quasar.challenge.domain.entity.Coordinate;

public class SOSMessageDTO {
    private Coordinate position;
    private String message;

    public SOSMessageDTO() {}

    public SOSMessageDTO(Coordinate c, String s) {
        this.position = c;
        this.message = s;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

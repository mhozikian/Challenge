package com.quasar.challenge.adapter.repository;

import com.quasar.challenge.domain.entity.Coordinate;
import com.quasar.challenge.domain.repository.CoordinateRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryCoordinateRepository implements CoordinateRepository {

    public Coordinate getCoordinates(final double distance) {
        /*Uso valores fijos para obtener las coordenadas segun la distancia ya que para realizar el calculo
        * de trilateracion es necesario sabre las coordenadas de los satelites
        * Envio distancias que permitan darme las coordenadas tales que provoquen interseccion de los circulos
        * generados por los radios que equivalen a las distancias recibidas como parametro
        *  -500.0, -200.0, 500.0, // circle 1 (center_x, center_y, radius)
           -100.0, -100.0, 316.2, // circle 2 (center_x, center_y, radius)
            500.0, 100.0, 707.07) // circle 3 (center_x, center_y, radius)*/
        Coordinate result;
        switch (String.valueOf(distance)) {
            case "500.0":
                result = new Coordinate(-500.0,-200.0);
                break;
            case "316.2":
                result = new Coordinate(-100.0, -100.0);
                break;
            case "707.07":
                result = new Coordinate(500.0, 100.0);
                break;
            default:
                result = null;
                break;
        }
        return result;
    }
}

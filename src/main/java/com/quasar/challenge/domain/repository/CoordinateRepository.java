package com.quasar.challenge.domain.repository;

import com.quasar.challenge.domain.entity.Coordinate;

public interface CoordinateRepository {

    Coordinate getCoordinates(double distance);

}

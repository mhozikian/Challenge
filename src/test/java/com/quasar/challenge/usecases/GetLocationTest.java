package com.quasar.challenge.usecases;

import com.quasar.challenge.adapter.repository.InMemoryCoordinateRepository;
import com.quasar.challenge.domain.entity.Coordinate;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class GetLocationTest {

    @InjectMocks
    private GetLocationUseCase getLocation;

    @Mock
    private InMemoryCoordinateRepository repository;

    @Before
    public void init(){
        getLocation = new GetLocationUseCase(repository);
        when(repository.getCoordinates(500.0)).thenReturn(new Coordinate(-500.0, -200.0));
        when(repository.getCoordinates(316.2)).thenReturn(new Coordinate(-100.0, -100.0));
        when(repository.getCoordinates(707.07)).thenReturn(new Coordinate(500.0, 100.0));
    }
    @Test
    public void GetLocation_getLocation_ShouldReturnCoordinates() throws Exception {
        /*List of distances*/
        ArrayList<Double> list = new ArrayList<>();
        list.add(500.0);
        list.add(316.2);
        list.add(707.07);
        assertEquals(-199.97, getLocation.getLocation(list).getLatitude(), 0.01);
        assertEquals(199.98, getLocation.getLocation(list).getLongitude(), 0.01);
    }
}
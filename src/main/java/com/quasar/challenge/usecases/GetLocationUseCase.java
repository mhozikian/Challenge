package com.quasar.challenge.usecases;

import com.quasar.challenge.adapter.repository.InMemoryCoordinateRepository;
import com.quasar.challenge.domain.entity.Coordinate;
import com.quasar.challenge.domain.exception.NotIntersectionException;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GetLocationUseCase {
    /*Establece el margen de error*/
    private static final double EPSILON = 0.01;

    private final InMemoryCoordinateRepository repository;

    public GetLocationUseCase(final InMemoryCoordinateRepository repository){
        this.repository = repository;
    }

    private Coordinate threeCircleIntersection(
            double px0, double py0, double r0,
            double px1, double py1, double r1,
            double px2, double py2, double r2){

        Coordinate coordinate = new Coordinate();
        double a, dx, dy, d, h, rx, ry;
        double point2_x, point2_y;

        /* dx distancia entre los puntos p0 y p1 en la coordenada x
         *  dy distancia entre los puntos p0 y p1 en la coordenada y */
        dx = px1 - px0;
        dy = py1 - py0;

        /* Distancia entre los puntos p0 y p1 */
        d = Math.sqrt((dy*dy) + (dx*dx));

        /* Valida si la distancia esta entre los radios determinados por los puntos p0 y p1 */
        if (d > (r0 + r1)){
            /* Los circulos no se intersectan*/
            throw new NotIntersectionException("Circles do not intersect.");
        }
        if (d < Math.abs(r0 - r1)){
            /* Un circulo está contenido en el otro*/
            throw new NotIntersectionException("Circle contained in another.");
        }

        /* Segunda parte: la linea que atravieza los puntos de interseccion de los dos circulos
        se cruza con la linea que atravieza los ejes de los dos circulos*/

        /* Determina la distancia entre el punto p0 y p2*/
        a = ((r0*r0) - (r1*r1) + (d*d))/(2.0 * d) ;

        /* Determina las coordenadas del punto p2. */
        point2_x = px0 + (dx * a/d);
        point2_y = py0 + (dy * a/d);

        /* Determina la distancia del punto p2 hacia cualquier punto de interseccion */
        h = Math.sqrt((r0*r0) - (a*a));

        /* Compensa los puntos de interseccion con point2 */
        rx = -dy * (h/d);
        ry = dx * (h/d);

        /* Determina los puntos de interseccion absoluta */
        double intersectionPoint1_x = point2_x + rx;
        double intersectionPoint2_x = point2_x - rx;
        double intersectionPoint1_y = point2_y + ry;
        double intersectionPoint2_y = point2_y - ry;

        /* Determina si el tercer circulo intersecta con alguno de los puntos de interseccion anteriores */
        dx = intersectionPoint1_x - px2;
        dy = intersectionPoint1_y - py2;
        double d1 = Math.sqrt((dy*dy) + (dx*dx));

        dx = intersectionPoint2_x - px2;
        dy = intersectionPoint2_y - py2;
        double d2 = Math.sqrt((dy*dy) + (dx*dx));

        System.out.println("punto x: " + intersectionPoint1_x + " punto y: " + intersectionPoint1_y);
        if(Math.abs(d1 - r2) < EPSILON) {
            coordinate.setLatitude((double)Math.round(intersectionPoint1_x * 100d) / 100d);
            coordinate.setLongitude((double)Math.round(intersectionPoint1_y * 100d) / 100d);
            System.out.println("punto x: " + intersectionPoint1_x + " punto y: " + intersectionPoint1_y);
        }
        else if(Math.abs(d2 - r2) < EPSILON) {
            coordinate.setLatitude((double)Math.round(intersectionPoint2_x * 100d) / 100d);
            coordinate.setLongitude((double)Math.round(intersectionPoint2_y * 100d) / 100d);
            System.out.println("punto x: " + (double)Math.round(intersectionPoint2_x * 100d) / 100d
                    + " punto y: " + (double)Math.round(intersectionPoint2_y * 100d) / 100d);
        }
        else {
            throw new NotIntersectionException("Circles do not intersect.");
        }
        return coordinate;
    }

    public Coordinate getLocation(List<Double> distances) throws Exception{
        double px0, py0, r0;
        double px1, py1, r1;
        double px2, py2, r2;

        /*Para cada distancia obtengo los puntos x e y de sus coordenadas
         * que asumo almacenadas*/
        List<Coordinate> coordinates = distances.stream().map(
                distance -> this.repository.getCoordinates(distance)).collect(toList());

        /*Se que son tres, asigno los resultados obtenidos a las variables que seran parametro en
         * la funcion de calculo*/
        px0 = coordinates.get(0).getLatitude();
        py0 = coordinates.get(0).getLongitude();
        r0 = distances.get(0);
        px1 = coordinates.get(1).getLatitude();
        py1 = coordinates.get(1).getLongitude();
        r1 = distances.get(1);
        px2 = coordinates.get(2).getLatitude();
        py2 = coordinates.get(2).getLongitude();
        r2 = distances.get(2);

        return this.threeCircleIntersection(px0, py0, r0, px1, py1, r1, px2, py2, r2);
    }
}

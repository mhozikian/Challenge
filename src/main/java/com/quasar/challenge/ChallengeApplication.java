package com.quasar.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@RestController*/
public class ChallengeApplication {

    /*private final GetLocationUseCase getLocation;
    private final GetMessageUseCase getMessage;

    public ChallengeApplication(GetLocationUseCase getLocation,
                                GetMessageUseCase getMessage) {
        this.getLocation = getLocation;
        this.getMessage = getMessage;
    }*/

    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
    }
/*
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) throws Exception {
        System.out.print("Hello %s!" + name + " inicia");
        /*-500.0, -200.0, 490.0, // circle 1 (center_x, center_y, radius)
          -100.0, -100.0, 425.0, // circle 2 (center_x, center_y, radius)
           500.0,  100.0, 695.0)*/
    /*    ArrayList<Double> list = new ArrayList<Double>();
        list.add(500.0);
        list.add(316.2);
        list.add(707.07);
        Coordinate c = getLocation.getLocation(list);
        return "x= " + c.getLatitude() + " y= " + c.getLongitude() ;
    }*/

   /* @GetMapping("/message")
    public String getMensaje() {
        /*Kenobi:  [“”, “este”, “es”, “un”, “mensaje”]
        Skywalker: [“este”, “”, “un”, “mensaje”]
        Sato:      [“”, ””, ”es”, ””, ”mensaje”]*/
     /*   ArrayList<String> kenobi = new ArrayList<String>();
        kenobi.add("este");
        kenobi.add("es");
        kenobi.add("");
        kenobi.add("mensaje");
        kenobi.add("");
        ArrayList<String> skywalker = new ArrayList<String>();
        skywalker.add("");
        skywalker.add("");
        skywalker.add("un");
        skywalker.add("mensaje");
        skywalker.add("");
        ArrayList<String> sato = new ArrayList<String>();
        sato.add("este");
        sato.add("");
        sato.add("");
        sato.add("mensaje");
        sato.add("secreto");
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        list.add(kenobi);
        list.add(skywalker);
        list.add(sato);
        String s = getMessage.getMessage(list);
        return s;
    }*/
}

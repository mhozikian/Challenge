package com.quasar.challenge.usecases;

import com.quasar.challenge.domain.exception.NoMessageReceivedException;

import java.util.ArrayList;
import java.util.List;

public class GetMessageUseCase {

    public String getMessage(List<ArrayList<String>> messages){
        ArrayList<String> result;
        /*Si existe algun mensaje recibido*/
        if(messages.size() >= 1) {
            /*Inicializo el resultado con el primer mensaje, el del primer arreglo*/
            result = messages.get(0);
            /*Itero a partir del segundo mensaje agregando los strings a las posiciones adecuadas*/
            for (int i = 1; i < messages.size(); ++i) {
                ArrayList<String> actual = messages.get(i);
                for (int j = 0; j < actual.size(); ++j) {
                    if (!actual.get(j).isEmpty()) {
                        result.set(j, actual.get(j));
                    }
                }
            }
        }else{
            throw new NoMessageReceivedException("No message Received");
        }
        return String.join(" ", result);
    }
}

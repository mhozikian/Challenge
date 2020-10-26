package com.quasar.challenge.domain.exception;

public class NoMessageReceivedException extends RuntimeException{
    public NoMessageReceivedException(final String msj) {
        super(msj);
    }
}

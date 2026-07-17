package com.example.racerankAPI.exception;

//Exception de tempo inválido
public class TempoInvalidoException extends RuntimeException{
    public TempoInvalidoException(String message){
        super(message);
    }
}

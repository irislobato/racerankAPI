package com.example.racerankAPI.exception;

//Exception de Conflito
public class ConflitoDeRecursoException extends RuntimeException{
    public ConflitoDeRecursoException(String message){
        super(message);
    }
}

package com.example.racerankAPI.exception;

//Exception de recurso não encontrado
public class RecursoNaoEncontradoException extends RuntimeException{
    public RecursoNaoEncontradoException(String message){
        super(message);
    }
}

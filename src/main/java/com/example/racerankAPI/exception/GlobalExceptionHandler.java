package com.example.racerankAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Controller dos erros detalhados
@RestControllerAdvice
public class GlobalExceptionHandler {

    //Erro para caso nao encontre o parÂmetro buscado pelo usuário
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ProblemDetail handleRecursoNaoEncontrado(RecursoNaoEncontradoException exception){
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
        problem.setTitle("Recurso Não Encontrado.");

        return problem;
    }

    //Erro para caso tente haver uma criação duplicada de recursos
    @ExceptionHandler(ConflitoDeRecursoException.class)
    public  ProblemDetail handleDuplicidadeNaCriacao(ConflitoDeRecursoException exception){
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, exception.getMessage());
        problem.setTitle("Recurso Já Existente.");

        return problem;
    }

    //Erro caso o tempo de voltas digitado seja menor que 0 milissegundos
    @ExceptionHandler(TempoInvalidoException.class)
    public  ProblemDetail handleTempoInvalido(TempoInvalidoException exception){
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
        problem.setTitle("Parâmetro de Negócio Inválido.");

        return problem;
    }

    //Erro de campo nulo
    @ExceptionHandler(ArgumentoInvalidoException.class)
    public ProblemDetail handleArgumentoInvalido(ArgumentoInvalidoException exception){
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
        problem.setTitle("Argumento iinválido.");

        return problem;
    }

    //Erro o qual engloba quaisquer erros não descritos anteriormente
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleErroGenerico(Exception exception){
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus., "Ocorreu uma falha imprevista no servidor, por favor contate o suporte.");
        problem.setTitle("Erro Interno do Servidor.");

        return problem;
    }
}
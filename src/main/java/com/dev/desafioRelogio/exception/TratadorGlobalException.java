package com.dev.desafioRelogio.exception;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;


@RestControllerAdvice
public class TratadorGlobalException {

    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseEntity<ErrorApi> tratarNaoEncontrado(NaoEncontradoException ex, HttpServletRequest req) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorApi(
                Instant.now(), 404, "Não encontrado", ex.getMessage(), req.getRequestURI(), List.of()
        ));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorApi> tratarRequisicaoInvalida(NaoEncontradoException ex, HttpServletRequest req) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorApi(
                Instant.now(), 400, "Requisição inválida", ex.getMessage(), req.getRequestURI(), List.of()
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorApi> tratarValidacao(MethodArgumentNotValidException ex, HttpServletRequest req) {
        List<ErrorApi.ErroCampo> campos = ex.getBindingResult().getFieldErrors().stream()
                .map(fe -> new ErrorApi.ErroCampo(fe.getField(), ex.getMessage()))
                .toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorApi(
                Instant.now(), 400, "Requisição inválida", "Erro de validação", req.getRequestURI(), List.of()
        ));
    }

}

package com.albertopaim.libraryApi.Controller.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ErroResposta(HttpStatus status, String message, List<ErroCampo> erros) {

    public static ErroResposta respostaPadrao(String mensagem) {
        return new ErroResposta(HttpStatus.BAD_REQUEST, mensagem, List.of());
    }

    public static ErroResposta conflito(String mensagem){
        return new ErroResposta(HttpStatus.CONFLICT, mensagem, List.of());
    }

}

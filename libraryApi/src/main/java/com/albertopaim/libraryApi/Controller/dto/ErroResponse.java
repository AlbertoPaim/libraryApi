package com.albertopaim.libraryApi.Controller.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ErroResponse(HttpStatus status, String message, List<ErroField> errors) {

    public static ErroResponse respostaPadrao(String message){
        return new ErroResponse(HttpStatus.BAD_REQUEST, message, List.of());
    }

    public static ErroResponse conflito(String message){
        return new ErroResponse(HttpStatus.CONFLICT, message, List.of() );
    }

}

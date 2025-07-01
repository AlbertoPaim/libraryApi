package com.albertopaim.libraryApi.Controller.dto;

import com.albertopaim.libraryApi.model.GeneroLivro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CadastroLivroDTO(
        @NotBlank(message = "Campo obrigatório")
        String isbn,
        @NotBlank(message = "Campo obrigatório")
        String titulo,
        @NotNull(message = "Campo obrigatório")
        @Past(message = "Não pode ser data passada")
        LocalDate dataPublicacao,
        GeneroLivro genero,
        BigDecimal preco,
        @NotNull(message = "Campo obrigatório")
        UUID autor
) {


}


package com.albertopaim.libraryApi.Controller.dto;

import com.albertopaim.libraryApi.model.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record AutorDTO(UUID id,
                       @NotBlank(message = "Campo obrigatório")
                       String name,
                       @NotNull(message = "Campo obrigatório")
                       LocalDate dataNascimento,
                       @NotBlank(message = "Campo obrigatório")
                       String nacionalidade) {

    public Autor mapearAutor() {
        Autor autor = new Autor();
        autor.setId(this.id);
        autor.setName(this.name);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);

        return autor;
    }
}

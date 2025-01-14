package com.albertopaim.libraryApi.Controller.dto;

import com.albertopaim.libraryApi.model.Autor;

import java.time.LocalDate;
import java.util.UUID;

public record AutorDTO(UUID id, String name, LocalDate dataNascimento, String nacionalidade) {

    public Autor mapearAutor() {
        Autor autor = new Autor();
        autor.setId(this.id);
        autor.setName(this.name);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);

        return autor;
    }
}

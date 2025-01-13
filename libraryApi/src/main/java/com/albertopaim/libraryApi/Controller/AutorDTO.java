package com.albertopaim.libraryApi.Controller;

import com.albertopaim.libraryApi.model.Autor;

import java.time.LocalDate;

public record AutorDTO(String name, LocalDate dataNascimento, String nacionalidade) {

    public Autor mapearAutor() {
        Autor autor = new Autor();
        autor.setName(this.name);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);

        return autor;
    }
}

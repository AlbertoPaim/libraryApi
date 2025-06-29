package com.albertopaim.libraryApi.Controller.dto;

import com.albertopaim.libraryApi.model.GeneroLivro;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ResultadoPesquisaLivroDTO(String isbn,
                                        String titulo,
                                        LocalDate dataPublicacao,
                                        GeneroLivro genero,
                                        BigDecimal preco,
                                        AutorDTO autor) {
}

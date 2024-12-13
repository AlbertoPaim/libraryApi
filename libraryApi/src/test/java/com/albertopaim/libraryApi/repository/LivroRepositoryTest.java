package com.albertopaim.libraryApi.repository;

import com.albertopaim.libraryApi.model.Autor;
import com.albertopaim.libraryApi.model.GeneroLivro;
import com.albertopaim.libraryApi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {
    @Autowired
    LivroRepository livroRepository;
    @Autowired
    AutorRepository autorRepository;

    @Test
    void criar() {

        Livro novoLivro = new Livro();
        novoLivro.setIsbn("teste");
        novoLivro.setTitulo("A queda dos aliens");
        novoLivro.setDataPublicacao(LocalDate.of(1800, 7, 19));
        novoLivro.setPreco(BigDecimal.valueOf(100));
        novoLivro.setGenero(GeneroLivro.FANTASIA);

        Autor autor = autorRepository.findById(UUID.fromString("0fa26526-470b-4695-8fd3-d562536325f4")).orElse(null);
        novoLivro.setAutor(autor);

        livroRepository.save(novoLivro);
    }
    @Test
    void getLivro(){
        UUID id = UUID.fromString("bb0ff5b5-fd7c-478c-91ce-222af62f54d8");
        Livro livroEncontrado = livroRepository.findById(id).orElse(null);

        System.out.println(livroEncontrado.getTitulo());

        Autor autorEncontrado = livroEncontrado.getAutor();
        System.out.println(autorEncontrado.getName());
    }
}
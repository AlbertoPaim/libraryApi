package com.albertopaim.libraryApi.repository;

import com.albertopaim.libraryApi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {
    @Autowired
    AutorRepository autorRepository;

    @Test
    public void salvarAutor() {
        Autor autor = new Autor();
        autor.setName("Alberto atualizado");
        autor.setDataNascimento(LocalDate.of(1998, 7, 19));
        autor.setNacionalidade("Brasileira");

        var newAutor = autorRepository.save(autor);

        System.out.println(newAutor);
    }

    @Test
    public void atualizarAutor() {
        var id = UUID.fromString("0fa26526-470b-4695-8fd3-d562536325f4");

        Optional<Autor> possivelAutor = autorRepository.findById(id);

        if (possivelAutor.isPresent()) {
            Autor autorEncontrado = possivelAutor.get();

            autorEncontrado.setDataNascimento(LocalDate.of(2000, 1, 8));

            autorRepository.save(autorEncontrado);

        }
    }
}


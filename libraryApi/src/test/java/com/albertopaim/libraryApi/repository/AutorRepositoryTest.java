package com.albertopaim.libraryApi.repository;

import com.albertopaim.libraryApi.model.Autor;
import com.albertopaim.libraryApi.model.GeneroLivro;
import com.albertopaim.libraryApi.model.Livro;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {
    @Autowired
    AutorRepository autorRepository;
    @Autowired
    LivroRepository livroRepository;

    @Test
    void salvarAutor() {
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

    @Test
    public void criarAutorComLivros() {
        Autor autor = new Autor();
        autor.setName("Tino ");
        autor.setDataNascimento(LocalDate.of(3000, 7, 19));
        autor.setNacionalidade("Brasileiro");

        Livro novoLivro = new Livro();
        novoLivro.setIsbn("21");
        novoLivro.setTitulo("A bela e a fera");
        novoLivro.setDataPublicacao(LocalDate.of(1800, 7, 19));
        novoLivro.setPreco(BigDecimal.valueOf(100));
        novoLivro.setGenero(GeneroLivro.ROMANCE);
        novoLivro.setAutor(autor);

        Livro novoLivro2 = new Livro();
        novoLivro2.setIsbn("22");
        novoLivro2.setTitulo("Historias de outlast");
        novoLivro2.setDataPublicacao(LocalDate.of(1800, 7, 19));
        novoLivro2.setPreco(BigDecimal.valueOf(100));
        novoLivro2.setGenero(GeneroLivro.TERROR);
        novoLivro2.setAutor(autor);


        autor.setLivros(new ArrayList<>());
        autor.getLivros().add(novoLivro);
        autor.getLivros().add(novoLivro2);

        autorRepository.save(autor);

        livroRepository.saveAll(autor.getLivros());
    }

    @Test
    @Transactional
    public void listarLivrosAutor() {
    UUID id = UUID.fromString("dc1c1923-9258-4208-9e64-38cbac8744e7");
    Autor autorEncontrado = autorRepository.findById(id).orElse(null);

        List<Livro> byAutor = livroRepository.findByAutor(autorEncontrado);

        autorEncontrado.setLivros(byAutor);

        autorEncontrado.getLivros().forEach(System.out::println);

    }
}


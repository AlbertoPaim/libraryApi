package com.albertopaim.libraryApi.repository;

import com.albertopaim.libraryApi.model.Autor;
import com.albertopaim.libraryApi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
List<Livro> findByAutor (Autor autor);

List<Livro> findByTitulo (String Titulo);
}

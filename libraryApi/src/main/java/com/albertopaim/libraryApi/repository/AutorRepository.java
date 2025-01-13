package com.albertopaim.libraryApi.repository;

import com.albertopaim.libraryApi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {

}

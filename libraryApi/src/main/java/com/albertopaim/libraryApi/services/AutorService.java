package com.albertopaim.libraryApi.services;

import com.albertopaim.libraryApi.model.Autor;
import com.albertopaim.libraryApi.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    public Optional<Autor> getAutorByid(UUID id) {
        return autorRepository.findById(id);
    }

    public void delete(Autor autor) {
        autorRepository.delete(autor);
    }
}


package com.albertopaim.libraryApi.services;

import com.albertopaim.libraryApi.model.Autor;
import com.albertopaim.libraryApi.repository.AutorRepository;
import com.albertopaim.libraryApi.validator.AutorValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    private final AutorValidator validator;

    public AutorService(AutorRepository autorRepository, AutorValidator validator) {
        this.autorRepository = autorRepository;
        this.validator = validator;
    }

    public Autor save(Autor autor) {
        validator.validar(autor);
        return autorRepository.save(autor);
    }

    public void update(Autor autor) {
        if (autor.getId() == null) {
            throw new IllegalArgumentException("Id nao cadastrado");
        }
        autorRepository.save(autor);
    }

    public Optional<Autor> getAutorByid(UUID id) {
        return autorRepository.findById(id);
    }

    public void delete(Autor autor) {
        autorRepository.delete(autor);
    }

    public List<Autor> searchAutor(String name, String nacionalidade) {
        if (name != null && nacionalidade != null) {
            return autorRepository.findByNameAndNacionalidade(name, nacionalidade);
        }
        if (name != null) {
            return autorRepository.findByName(name);
        }
        if (nacionalidade != null) {
            return autorRepository.findByNacionalidade(nacionalidade);
        }

        return autorRepository.findAll();
    }
}

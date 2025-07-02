package com.albertopaim.libraryApi.services;

import com.albertopaim.libraryApi.model.Livro;
import com.albertopaim.libraryApi.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public Optional<Livro> obterLivro(UUID id) {
        return livroRepository.findById(id);
    }


}

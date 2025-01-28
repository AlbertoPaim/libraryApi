package com.albertopaim.libraryApi.validator;

import com.albertopaim.libraryApi.exceptions.RegistroDuplicadosExceptions;
import com.albertopaim.libraryApi.model.Autor;
import com.albertopaim.libraryApi.repository.AutorRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AutorValidator {

    private AutorRepository autorRepository;

    public AutorValidator(AutorRepository autorRepository) {

        this.autorRepository = autorRepository;
    }

    public void validar(Autor autor) {

        if (existeAutorCadastrado(autor)) {
            throw new RegistroDuplicadosExceptions("Autor já cadastrado");
        }

    }

    private boolean existeAutorCadastrado(Autor autor) {
        Optional<Autor> autorEncontrado = autorRepository.findByNameAndDataNascimentoAndNacionalidade(autor.getName(), autor.getDataNascimento(), autor.getNacionalidade());

        if (autor.getId() == null) {
            return autorEncontrado.isPresent();
        }

        return !autor.getId().equals(autorEncontrado.get().getId()) && autorEncontrado.isPresent();
    }
}

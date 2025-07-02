package com.albertopaim.libraryApi.Controller;

import com.albertopaim.libraryApi.Controller.dto.CadastroLivroDTO;
import com.albertopaim.libraryApi.Controller.dto.ErroResposta;
import com.albertopaim.libraryApi.Controller.dto.ResultadoPesquisaLivroDTO;
import com.albertopaim.libraryApi.Controller.mappers.LivroMapper;
import com.albertopaim.libraryApi.exceptions.RegistroDuplicadosExceptions;
import com.albertopaim.libraryApi.model.Livro;
import com.albertopaim.libraryApi.services.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("livros")
@RestController
@RequiredArgsConstructor
public class LivroController {
    private final LivroMapper mapper;
    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<Object> criarLivro(@RequestBody @Valid CadastroLivroDTO livroDTO) {
        try {
            Livro livro = mapper.toEntity(livroDTO);
            livroService.salvar(livro);

            return ResponseEntity.ok(livro);
        } catch (RegistroDuplicadosExceptions e) {
            var erroDTO = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<ResultadoPesquisaLivroDTO> dobterDetalhes(@PathVariable("id") String id) {
        return livroService.obterLivro(UUID.fromString(id)).map(livro -> {
            var dto = mapper.toDto(livro);
            return ResponseEntity.ok(dto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    ;
}

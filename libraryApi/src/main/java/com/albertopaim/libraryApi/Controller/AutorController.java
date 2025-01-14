package com.albertopaim.libraryApi.Controller;


import com.albertopaim.libraryApi.Controller.dto.AutorDTO;
import com.albertopaim.libraryApi.model.Autor;
import com.albertopaim.libraryApi.services.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/autores")
public class AutorController {

    private AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody AutorDTO autor) {
        Autor autorEntity = autor.mapearAutor();
        autorService.save(autorEntity);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(autorEntity.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @GetMapping("{id}")
    public ResponseEntity<AutorDTO> getAutor(@PathVariable("id") String id) {
        var idAutor = UUID.fromString(id);

        Optional<Autor> autorOptional = autorService.getAutorByid(idAutor);

        if (autorOptional.isPresent()) {
            Autor autor = autorOptional.get();
            AutorDTO dto = new AutorDTO(autor.getId(), autor.getName(), autor.getDataNascimento(), autor.getNacionalidade());

            return ResponseEntity.ok(dto);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable("id") String id) {
        var idAutor = UUID.fromString(id);
        Optional<Autor> autorOptional = autorService.getAutorByid(idAutor);

        if (autorOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        autorService.delete(autorOptional.get());

        return ResponseEntity.noContent().build();

    }

    @GetMapping
    public ResponseEntity<List<AutorDTO>> getAutores(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "nacionalidade", required = false) String nacionalidade){

        List<Autor> resultado = autorService.searchAutor(name, nacionalidade);

        List<AutorDTO> listaDto = resultado.stream().map(autor -> new AutorDTO(autor.getId(), autor.getName(), autor.getDataNascimento(), autor.getNacionalidade())).collect(Collectors.toList());

        return ResponseEntity.ok(listaDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateAutores(@PathVariable("id") String id,@RequestBody AutorDTO autorDTO) {

        var idAutor = UUID.fromString(id);
        Optional<Autor> autorOptional = autorService.getAutorByid(idAutor);

        if (autorOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var autor = autorOptional.get();
        autor.setName(autorDTO.name());
        autor.setDataNascimento(autorDTO.dataNascimento());
        autor.setNacionalidade(autorDTO.nacionalidade());

        autorService.update(autor);

        return ResponseEntity.noContent().build();
    }
}

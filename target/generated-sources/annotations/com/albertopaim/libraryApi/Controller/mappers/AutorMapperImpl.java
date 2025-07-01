package com.albertopaim.libraryApi.Controller.mappers;

import com.albertopaim.libraryApi.Controller.dto.AutorDTO;
import com.albertopaim.libraryApi.model.Autor;
import java.time.LocalDate;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-01T18:16:50-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class AutorMapperImpl implements AutorMapper {

    @Override
    public Autor toEntity(AutorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Autor autor = new Autor();

        autor.setId( dto.id() );
        autor.setName( dto.name() );
        autor.setDataNascimento( dto.dataNascimento() );
        autor.setNacionalidade( dto.nacionalidade() );

        return autor;
    }

    @Override
    public AutorDTO toDTO(Autor autor) {
        if ( autor == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        LocalDate dataNascimento = null;
        String nacionalidade = null;

        id = autor.getId();
        name = autor.getName();
        dataNascimento = autor.getDataNascimento();
        nacionalidade = autor.getNacionalidade();

        AutorDTO autorDTO = new AutorDTO( id, name, dataNascimento, nacionalidade );

        return autorDTO;
    }
}

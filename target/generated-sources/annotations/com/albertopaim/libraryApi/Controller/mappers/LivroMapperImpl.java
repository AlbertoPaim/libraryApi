package com.albertopaim.libraryApi.Controller.mappers;

import com.albertopaim.libraryApi.Controller.dto.CadastroLivroDTO;
import com.albertopaim.libraryApi.model.Livro;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-01T18:16:50-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class LivroMapperImpl extends LivroMapper {

    @Override
    public Livro toEntity(CadastroLivroDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Livro livro = new Livro();

        livro.setIsbn( dto.isbn() );
        livro.setTitulo( dto.titulo() );
        livro.setDataPublicacao( dto.dataPublicacao() );
        livro.setGenero( dto.genero() );
        livro.setPreco( dto.preco() );

        livro.setAutor( autorRepository.findById(dto.autor()).orElse(null) );

        return livro;
    }
}

package com.albertopaim.libraryApi.Controller.mappers;

import com.albertopaim.libraryApi.Controller.dto.CadastroLivroDTO;
import com.albertopaim.libraryApi.model.Livro;
import com.albertopaim.libraryApi.repository.AutorRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class LivroMapper {

    @Autowired
    protected AutorRepository autorRepository;

    @Mapping(target = "autor", expression = "java(autorRepository.findById(dto.autor()).orElse(null))")
    public abstract Livro toEntity(CadastroLivroDTO dto);
}
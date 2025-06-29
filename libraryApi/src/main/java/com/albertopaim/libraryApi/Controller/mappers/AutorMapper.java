package com.albertopaim.libraryApi.Controller.mappers;

import com.albertopaim.libraryApi.Controller.dto.AutorDTO;
import com.albertopaim.libraryApi.model.Autor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    Autor toEntity(AutorDTO dto);

    AutorDTO toDTO(Autor autor);
}

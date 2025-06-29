package com.albertopaim.libraryApi.Controller;

import com.albertopaim.libraryApi.services.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("livros")
@RestController
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

}

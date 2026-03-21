package io.github.cursodsousa.libraryapi.controller.dto;

import io.github.cursodsousa.libraryapi.model.GeneroLivro;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ResultadoPesquisaLivroDTO(
        Integer id,
        String isbn,
        String titulo,
        LocalDate dataPublicacao,
        GeneroLivro genero,
        BigDecimal preco,
        AutorDTO autor) {
}

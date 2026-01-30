package io.github.cursodsousa.libraryapi.controller.dto;

import io.github.cursodsousa.libraryapi.model.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AutorDTO(
        Integer id,

        @NotBlank(message = "campo obrigatorio")
        @Size( min = 2, max = 100, message = "campo fora do tamanho padrao")
        String nome,

        @Past(message = "nao pode ser data futura")
        @NotNull(message = "campo obrigatorio")
        LocalDate dataNascimento,

        @NotBlank(message = "campo obrigatorio")
        @Size( min = 2, max = 100, message = "campo fora do tamanho padrao")
        String nacionalidade) {

    public Autor mapearParaAutor() {
        Autor autor = new Autor();
        autor.setId(id);
        autor.setNome(this.nome);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);
        return autor;
    }
}

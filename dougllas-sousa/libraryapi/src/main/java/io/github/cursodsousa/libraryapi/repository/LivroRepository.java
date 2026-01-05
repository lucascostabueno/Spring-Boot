package io.github.cursodsousa.libraryapi.repository;

import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Integer>  {

    List<Livro> FindByAutor(Autor autor);

    List<Livro> findByTitulo(String titulo);

    List<Livro> FindByIsbn(String isbn);

    List<Livro> findByTituloAndPreco(String titulo, BigDecimal preco);

    List<Livro> FindByTituloOrIsbn(String titulo, String isbn);

    List<Livro> FindByDataPublicacaoBetween (LocalDate inicio, LocalDate fim);
}

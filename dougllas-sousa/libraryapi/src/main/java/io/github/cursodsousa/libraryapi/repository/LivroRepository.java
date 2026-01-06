package io.github.cursodsousa.libraryapi.repository;

import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.model.GeneroLivro;
import io.github.cursodsousa.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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

    @Query("select l from Livro as l order by l.titulo, l.preco")
    List<Livro> listarTodosOrdenadoPorTituloAndPreco();

    //select a.
    //from Livro l
    //join autor a on a.id = l.id_autor
    @Query("select a from Livro l join l.autor a")
    List<Autor> listarAutoresDosLivros();

    @Query(""" 
    select l.genero
    from Livro l
    join l.autor a
    where a.nacionalidade = 'Brasileira'
    order by l.genero
    """)
    List<String> listarGenerosAutoresBrasileiros();

    @Query("select l from Livro l where l.genero = :genero order by :paramOrdenacao")
    List<Livro> findByGenero (
            @Param("genero") GeneroLivro generolivro,
            @Param("paramOrdenacao") String nomePropriedade
    );

    @Modifying
    @Transactional
    @Query("delete from Livro where genero = :genero")
    void deleteByGenero(GeneroLivro genero);

    @Modifying
    @Transactional
    @Query("update Livro set dataPublicacao = :novadata"
    void updateDataPublicacao (LocalDate novadata);
}

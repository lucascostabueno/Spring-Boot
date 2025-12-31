package io.github.cursodsousa.libraryapi.repository;

import io.github.cursodsousa.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer>  {
}

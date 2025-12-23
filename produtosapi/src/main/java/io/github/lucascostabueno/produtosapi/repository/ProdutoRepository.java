package io.github.lucascostabueno.produtosapi.repository;

import io.github.lucascostabueno.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}

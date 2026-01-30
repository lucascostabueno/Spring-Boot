package io.github.cursodsousa.libraryapi.service;

import io.github.cursodsousa.libraryapi.exceptions.OperacaoNaoPermitidaException;
import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.repository.AutorRepository;
import io.github.cursodsousa.libraryapi.repository.LivroRepository;
import io.github.cursodsousa.libraryapi.validator.AutorValidor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AutorService {
    private final AutorRepository autorRepository;
    private final AutorValidor autorValidor;
    private final LivroRepository livroRepository;

    public Autor salvar(Autor autor) {
        autorValidor.validar(autor);
        return autorRepository.save(autor);
    }

    public void atualizar(Autor autor) {
        if(autor.getId() == null) {
            throw new IllegalArgumentException("Para atualizar, é necessário que o autor já esteja salvo na base");
        }
        autorValidor.validar(autor);
         autorRepository.save(autor);
    }

    public Optional<Autor> obterPorId(Integer id) {
        return autorRepository.findById(id);
    }

    public void deletar(Autor autor) {
        if(possuiLivro(autor)) {
            throw new OperacaoNaoPermitidaException(
                    "Não é permitido excluir um autor que possui livros cadastrados!"
            );
        }
        autorRepository.delete(autor);
    }

    public List<Autor> pesquisa(String nome, String nacionalidade) {
        if(nome != null && nacionalidade != null){
            return autorRepository.findByNomeAndNacionalidade (nome, nacionalidade);
        }
        if(nome != null){
            return autorRepository.findByNome(nome);
        }
        if(nacionalidade != null) {
            return autorRepository.findByNacionalidade (nacionalidade);
        }
        return autorRepository.findAll();
    }

    public boolean possuiLivro(Autor autor) {
      return livroRepository.existsByAutor(autor);
    }
}

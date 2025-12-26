package io.github.lucascostabueno.arquiteturaspring.montadora.api;

import io.github.lucascostabueno.arquiteturaspring.montadora.Chave;
import io.github.lucascostabueno.arquiteturaspring.montadora.HondaHRV;
import io.github.lucascostabueno.arquiteturaspring.montadora.Motor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteFabricaController {

    @Autowired
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave) {
        var carro = new HondaHRV(motor);
        return carro.darIgnicao(chave);
    }
}

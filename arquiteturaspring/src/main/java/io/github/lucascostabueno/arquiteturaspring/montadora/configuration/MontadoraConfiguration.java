package io.github.lucascostabueno.arquiteturaspring.montadora.configuration;

import io.github.lucascostabueno.arquiteturaspring.montadora.Motor;
import io.github.lucascostabueno.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MontadoraConfiguration {
    @Bean
    public Motor motor() {
        var motor = new Motor();
        motor.setCavalos (120);
        motor.setCilindros (4);
        motor.setModelo ("XPTO-8");
        motor.setLitragem(2.0);
        motor.setTipo (TipoMotor.ASPIRADO);
        return motor;
    }
}

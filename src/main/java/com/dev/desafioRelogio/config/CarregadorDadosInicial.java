package com.dev.desafioRelogio.config;

import com.dev.desafioRelogio.entity.Relogio;
import com.dev.desafioRelogio.entity.enums.MaterialCaixa;
import com.dev.desafioRelogio.entity.enums.TipoMovimento;
import com.dev.desafioRelogio.entity.enums.TipoVidro;
import com.dev.desafioRelogio.repository.RelogioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Configuration
@RequiredArgsConstructor
public class CarregadorDadosInicial {

    private final RelogioRepository repository;

    @Bean
    CommandLineRunner seedRelogios() {
        return args -> {
            if (repository.count() > 0) return;

            Instant agora = Instant.now();

            List<Relogio> relogios = List.of(
                    Relogio.builder()
                            .id(UUID.randomUUID())
                            .marca("Casio")
                            .modelo("F-91WD")
                            .referencia("1234")
                            .tipoMovimento(TipoMovimento.QUARTZ)
                            .materialCaixa(MaterialCaixa.RESINA)
                            .tipoVidro(TipoVidro.ACRILICO)
                            .resistenciaAguaM(30)
                            .diametroMm(35)
                            .lugToLugMm(38)
                            .espessuraMm(9)
                            .larguraMm(18)
                            .precoEmCentavos(12990)
                            .urlImagem("123")
                            .criadoEm(agora.minusSeconds(50000))
                            .build(),
                    Relogio.builder()
                            .id(UUID.randomUUID())
                            .marca("Seiko")
                            .modelo("Diver 200m")
                            .referencia("890")
                            .tipoMovimento(TipoMovimento.AUTOMATICO)
                            .materialCaixa(MaterialCaixa.ACO)
                            .tipoVidro(TipoVidro.MINERAL)
                            .resistenciaAguaM(42)
                            .diametroMm(46)
                            .lugToLugMm(50)
                            .espessuraMm(13)
                            .larguraMm(22)
                            .precoEmCentavos(159990)
                            .urlImagem("456")
                            .criadoEm(agora.minusSeconds(30000))
                            .build(),
                    Relogio.builder()
                            .id(UUID.randomUUID())
                            .marca("Citizen")
                            .modelo("Eco-Diver Field")
                            .referencia("888888")
                            .tipoMovimento(TipoMovimento.QUARTZ)
                            .materialCaixa(MaterialCaixa.ACO)
                            .tipoVidro(TipoVidro.MINERAL)
                            .resistenciaAguaM(42)
                            .diametroMm(46)
                            .lugToLugMm(50)
                            .espessuraMm(13)
                            .larguraMm(22)
                            .precoEmCentavos(159990)
                            .urlImagem("456")
                            .criadoEm(agora.minusSeconds(30000))
                            .build()
            );
            repository.saveAll(relogios);
        };
    }

}

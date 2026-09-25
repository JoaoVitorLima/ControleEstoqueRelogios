package com.dev.desafioRelogio.mapper;

import com.dev.desafioRelogio.dto.RelogioDTO;
import com.dev.desafioRelogio.entity.Relogio;
import com.dev.desafioRelogio.entity.enums.MaterialCaixa;
import com.dev.desafioRelogio.entity.enums.TipoMovimento;
import com.dev.desafioRelogio.entity.enums.TipoVidro;
import org.springframework.stereotype.Component;

@Component
public class RelogioMapper {

    public RelogioDTO toDto(Relogio r) {
        return RelogioDTO.builder()
                .id(r.getId())
                .marca((r.getMarca()))
                .referencia(r.getReferencia())
                .tipoMovimento(r.getTipoMovimento().toApi())
                .materialCaixa(r.getMaterialCaixa().toApi())
                .tipoVidro(r.getTipoVidro().toApi())
                .resistenciaAguaM(r.getResistenciaAguaM())
                .diametroMm(r.getDiametroMm())
                .lugToLugMm(r.getLugToLugMm())
                .espessuraMm(r.getEspessuraMm())
                .larguraMm(r.getLarguraMm())
                .precoEmCentavos(r.getPrecoEmCentavos())
                .urlImagem(r.getUrlImagem())
                .etiquetaResistenciaAgua(etiquetaResistencia(r.getResistenciaAguaM()))
                .pontuacaoColecionador(pontuacaoColecionador(r))
                .build();
    }

    private String etiquetaResistencia(int resistenciaM) {
        if (resistenciaM < 50) return "respingos";
        if (resistenciaM < 100) return "uso_diario";
        if (resistenciaM < 200) return "natacao";
        return "mergulho";
    }

    private int pontuacaoColecionador(Relogio r) {
        int pontos = 0;

        if (r.getTipoVidro() == TipoVidro.SAFIRA) pontos += 25;

        if (r.getResistenciaAguaM() >= 100) pontos += 15;
        if (r.getResistenciaAguaM() >= 200) pontos += 10;

        if (r.getTipoMovimento() == TipoMovimento.AUTOMATICO) pontos += 20;

        if (r.getMaterialCaixa() == MaterialCaixa.CERAMICA) pontos += 12;
        if (r.getMaterialCaixa() == MaterialCaixa.TITANIO) pontos += 12;

        if (r.getDiametroMm() >= 38 && r.getDiametroMm() <= 42) pontos += 8;

        return pontos;
    }
}

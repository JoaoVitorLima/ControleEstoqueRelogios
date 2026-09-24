package com.dev.desafioRelogio.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record RelogioDTO (
        UUID id,
        String marca,
        String modelo,
        String referencia,
        String tipoMovimento,
        String materialCaixa,
        String tipoVidro,
        int resistenciaAguaM,
        int diametroMm,
        int lugToLugMm,
        int espessuraMm,
        int larguraMm,
        long precoEmCentavos,
        String urlImagem,
        String etiquetaResistenciaAgua,
        int pontuacaoColecionador
) {

}

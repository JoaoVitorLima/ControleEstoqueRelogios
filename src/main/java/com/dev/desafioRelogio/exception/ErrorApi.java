package com.dev.desafioRelogio.exception;

import java.time.Instant;
import java.util.List;

public record ErrorApi(
        Instant timestamp,
        int status,
        String erro,
        String mensagem,
        String caminho,
        List<ErroCampo> errrosDeCampo
) {
    public record ErroCampo(String campo, String mensagem) {}
}

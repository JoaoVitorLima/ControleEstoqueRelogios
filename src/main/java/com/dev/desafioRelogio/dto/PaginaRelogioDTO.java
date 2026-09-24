package com.dev.desafioRelogio.dto;

import java.util.List;

public record PaginaRelogioDTO(
        List<RelogioDTO> itens,
        long total
) {
}

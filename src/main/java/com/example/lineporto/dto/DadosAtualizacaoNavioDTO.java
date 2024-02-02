package com.example.lineporto.dto;

public record DadosAtualizacaoNavioDTO(
        Long id,
        String imo,
        String nome,
        double comprimento,
        double largura,
        double dwt,
        String produto,
        String agente,
        String empresa
) {
}

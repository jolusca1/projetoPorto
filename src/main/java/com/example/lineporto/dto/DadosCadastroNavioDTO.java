package com.example.lineporto.dto;

import com.example.lineporto.model.Berco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroNavioDTO(
        @NotBlank
        String imo,
        @NotBlank
        String nome,
        @NotNull
        double comprimento,
        @NotNull
        double largura,
        @NotNull
        double dwt,
        @NotBlank
        String produto,
        @NotBlank
        String agente,
        @NotBlank
        String empresa,

        @NotBlank
        Berco berco
) {
}

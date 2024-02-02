package com.example.lineporto.dto;

import com.example.lineporto.model.Navio;

public record DadosDetalhamentoNavioDTO(Long id, String imo, String nome, double comprimento, double largura, double dwt, String produto, String agente, String empresa) {

    public DadosDetalhamentoNavioDTO(Navio navio) {
        this(navio.getId(), navio.getImo(), navio.getNome(), navio.getComprimento(), navio.getLargura(), navio.getDwt(), navio.getProduto(), navio.getAgente(), navio.getEmpresa());
    }

}

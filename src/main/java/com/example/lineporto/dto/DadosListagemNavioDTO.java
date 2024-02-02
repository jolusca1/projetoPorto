package com.example.lineporto.dto;

import com.example.lineporto.model.Berco;
import com.example.lineporto.model.Navio;

public record DadosListagemNavioDTO(String imo, String nome, double comprimento, double largura, double dwt, String produto, String agente, String empresa, Boolean ativo, Berco berco) {
    public DadosListagemNavioDTO(Navio navio) {
        this(navio.getImo(), navio.getNome(), navio.getComprimento(), navio.getLargura(), navio.getDwt(), navio.getProduto(), navio.getAgente(), navio.getEmpresa(), navio.getAtivo(), navio.getBerco());
    }
}

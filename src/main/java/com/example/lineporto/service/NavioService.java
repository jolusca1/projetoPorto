package com.example.lineporto.service;


import com.example.lineporto.dto.DadosListagemNavioDTO;
import com.example.lineporto.model.Navio;
import com.example.lineporto.repository.NavioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavioService {

    @Autowired
    private NavioRepository navioRepository;

    public List<DadosListagemNavioDTO> getListNaviosAtivo(Pageable paginacao) {
        return navioRepository.findAtivo(paginacao);
    }

    public Navio saveNavio(Navio dados) {
        return navioRepository.save(dados);
    }
}

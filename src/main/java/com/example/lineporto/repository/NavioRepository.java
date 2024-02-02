package com.example.lineporto.repository;

import com.example.lineporto.dto.DadosListagemNavioDTO;
import com.example.lineporto.model.Navio;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NavioRepository extends JpaRepository<Navio, Long> {

    @Query("select n from Navio n where n.ativo = true")
    List<DadosListagemNavioDTO> findAtivo(Pageable paginacao);
}

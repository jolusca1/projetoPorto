package com.example.lineporto.controller;

import com.example.lineporto.dto.DadosCadastroNavioDTO;
import com.example.lineporto.dto.DadosListagemNavioDTO;
import com.example.lineporto.model.Navio;
import com.example.lineporto.service.NavioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("navios")
public class NavioController {

    @Autowired
    private NavioService navioService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<DadosListagemNavioDTO>> listNavios(@PageableDefault(size = 10) Pageable paginacao) {
        var page = navioService.getListNaviosAtivo(paginacao);
        return ResponseEntity.ok(page);
    }


    @PostMapping
    @Transactional
    public ResponseEntity postNavio(@RequestBody DadosCadastroNavioDTO dados) {

        Navio navio = convertToEntity(dados);

        Navio navioSalvo = navioService.saveNavio(navio);

        DadosCadastroNavioDTO savedNavio = convertToDTO(navioSalvo);

        return new ResponseEntity<>(savedNavio, HttpStatus.CREATED);

    }
    private Navio convertToEntity(DadosCadastroNavioDTO dadosCadastroNavioDTO) {
        return modelMapper.map(dadosCadastroNavioDTO, Navio.class);
    }

    private DadosCadastroNavioDTO convertToDTO(Navio navio) {
        return modelMapper.map(navio, DadosCadastroNavioDTO.class);
    }
}

//    @PutMapping("/{id}")
//    @Transactional
//    public ResponseEntity putNavio(@RequestBody @Valid DadosAtualizacaoNavioDTO dados, @PathVariable Long id) {
//        var navio = repository.getReferenceById(id);
//        navio.atualizarInformacao(dados);
//
//        return ResponseEntity.ok(new DadosDetalhamentoNavioDTO(navio));
//    }
//
//    @DeleteMapping("/{id}")
//    @Transactional
//    public ResponseEntity deleteNavio(@PathVariable Long id) {
//        var navio = repository.getReferenceById(id);
//        navio.delecaoLogica();
//
//        return ResponseEntity.noContent().build();
//    }
//}
package com.ubots.avaliacao.controller;

import com.ubots.avaliacao.dto.SolicitacaoDTO;
import com.ubots.avaliacao.model.Solicitacao;
import com.ubots.avaliacao.service.DistribuicaoService;
import com.ubots.avaliacao.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    @Autowired
    private DistribuicaoService distribuicaoService;

    @Autowired
    private SolicitacaoService solicitacaoService;

    @PostMapping
    public ResponseEntity<String> novaSolicitacao(@RequestBody Solicitacao solicitacao) {
        distribuicaoService.distribuirSolicitacao(solicitacao);
        return ResponseEntity.ok("Solicitação recebida e será processada.");
    }

    @GetMapping
    public ResponseEntity<List<SolicitacaoDTO>> listarTodasSolicitacoes() {
        return ResponseEntity.ok(solicitacaoService.listarTodas());
    }

    @PatchMapping("/{id}/concluir")
    public ResponseEntity<String> concluirSolicitacao(@PathVariable Long id) {
        boolean concluido = solicitacaoService.concluirSolicitacao(id);

        if (concluido) {
            return ResponseEntity.ok("Solicitação concluída com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("Falha ao concluir a solicitação.");
        }
    }

}


package com.ubots.avaliacao.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class GerenciadorDeFilasService {

    @Autowired
    private DistribuicaoService distribuicaoService;

    @Scheduled(fixedRate = 30000)
    public void verificarFilaESolicitarAtendimento() {
        distribuicaoService.processarFila();
    }
}

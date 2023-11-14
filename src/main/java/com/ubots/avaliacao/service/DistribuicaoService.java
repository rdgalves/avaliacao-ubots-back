package com.ubots.avaliacao.service;

import com.ubots.avaliacao.enums.EquipeEnum;
import com.ubots.avaliacao.enums.StatusSolicitacaoEnum;
import com.ubots.avaliacao.enums.TipoSolicitacaoEnum;
import com.ubots.avaliacao.repository.AtendenteRepository;
import com.ubots.avaliacao.model.Atendente;
import com.ubots.avaliacao.model.Fila;
import com.ubots.avaliacao.model.Solicitacao;
import com.ubots.avaliacao.repository.FilaRepository;
import com.ubots.avaliacao.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DistribuicaoService {
    private static final int MAX_ATENDIMENTOS_SIMULTANEOS = 3;

    @Autowired
    private AtendenteRepository atendenteRepository;

    @Autowired
    private FilaRepository filaRepository;
    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    public void distribuirSolicitacao(Solicitacao solicitacao) {
        EquipeEnum equipe = identificarEquipe(solicitacao.getTipo());
        Atendente atendenteDisponivel = encontrarAtendenteDisponivel(equipe);

        if (atendenteDisponivel != null) {
            atenderSolicitacao(solicitacao, atendenteDisponivel);
        } else {
            solicitacaoRepository.save(solicitacao);
            filaSolicitacao(solicitacao, equipe);
        }
    }

    public void processarFila() {
        List<Fila> filas = filaRepository.findAll();
        for (Fila fila : filas) {
            Solicitacao solicitacao = solicitacaoRepository.findById(fila.getSolicitacaoId()).orElse(null);
            if (solicitacao != null) {
                Atendente atendenteDisponivel = encontrarAtendenteDisponivel(fila.getEquipe());
                if (atendenteDisponivel != null) {
                    atenderSolicitacao(solicitacao, atendenteDisponivel);
                    filaRepository.delete(fila);
                }
            }
        }
    }

    private EquipeEnum identificarEquipe(TipoSolicitacaoEnum tipo) {
        switch (tipo) {
            case PROBLEMAS_COM_CARTAO:
                return EquipeEnum.CARTOES;
            case CONTRATACAO_EMPRESTIMO:
                return EquipeEnum.EMPRESTIMOS;
            default:
                return EquipeEnum.OUTROS_ASSUNTOS;
        }
    }

    private Atendente encontrarAtendenteDisponivel(EquipeEnum equipe) {
        List<Atendente> atendentes = atendenteRepository.findByEquipe(equipe);
        return atendentes.stream()
                .filter(a -> a.getAtendimentosSimultaneos() < MAX_ATENDIMENTOS_SIMULTANEOS)
                .findFirst()
                .orElse(null);
    }

    private void atenderSolicitacao(Solicitacao solicitacao, Atendente atendente) {
        atendente.addSolicitacao(solicitacao);
        solicitacao.setStatus(StatusSolicitacaoEnum.EM_ATENDIMENTO);
        atendenteRepository.save(atendente);
    }

    private void filaSolicitacao(Solicitacao solicitacao, EquipeEnum equipe) {
        Fila fila = new Fila();
        fila.setSolicitacaoId(solicitacao.getSolicitacaoId());
        fila.setEquipe(equipe);
        fila.setDataHoraEnfileiramento(LocalDateTime.now());
        filaRepository.save(fila);
    }


}


package com.ubots.avaliacao.service;

import com.ubots.avaliacao.dto.SolicitacaoDTO;
import com.ubots.avaliacao.enums.StatusSolicitacaoEnum;
import com.ubots.avaliacao.mapper.SolicitacaoMapper;
import com.ubots.avaliacao.model.Atendente;
import com.ubots.avaliacao.model.Solicitacao;
import com.ubots.avaliacao.repository.AtendenteRepository;
import com.ubots.avaliacao.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SolicitacaoService {
    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private AtendenteRepository atendenteRepository;

    public List<SolicitacaoDTO> listarTodas() {
        List<Solicitacao> solicitacoes = solicitacaoRepository.findAll();
        return solicitacoes.stream()
                .map(SolicitacaoMapper.INSTANCE::solicitacaoToSolicitacaoDTO)
                .collect(Collectors.toList());
    }

    public boolean concluirSolicitacao(Long id) {
        Optional<Solicitacao> solicitacaoOpt = solicitacaoRepository.findById(id);

        if (solicitacaoOpt.isPresent()) {
            Solicitacao solicitacao = solicitacaoOpt.get();
            solicitacao.setStatus(StatusSolicitacaoEnum.CONCLUIDA);
            solicitacaoRepository.save(solicitacao);

            Atendente atendente = atendenteRepository.findById(solicitacao.getAtendente().getAtendenteId()).orElse(null);
            if (atendente != null) {
                atendente.diminuirAtendimentosSimultaneos();
                atendenteRepository.save(atendente);
            }
            return true;
        }

        return false;
    }
}

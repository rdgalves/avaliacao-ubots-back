package com.ubots.avaliacao.model;


import com.ubots.avaliacao.enums.EquipeEnum;
import com.ubots.avaliacao.enums.TipoSolicitacaoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@Table(name = "atendentes")
public class Atendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long atendenteId;

    private String nome;

    @Enumerated(EnumType.STRING)
    private EquipeEnum equipe;

    private int atendimentosSimultaneos;

    @OneToMany(mappedBy = "atendente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Solicitacao> solicitacoes;

    public Atendente() {
        this.solicitacoes = new ArrayList<>();
    }

    public void addSolicitacao(Solicitacao solicitacao) {
        solicitacoes.add(solicitacao);
        solicitacao.setAtendente(this);
        atendimentosSimultaneos++;
    }

    public void diminuirAtendimentosSimultaneos() {
        if (this.atendimentosSimultaneos > 0) {
            this.atendimentosSimultaneos -= 1;
        }
    }
}
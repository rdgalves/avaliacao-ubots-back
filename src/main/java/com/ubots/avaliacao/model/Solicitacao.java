package com.ubots.avaliacao.model;

import com.ubots.avaliacao.enums.StatusSolicitacaoEnum;
import com.ubots.avaliacao.enums.TipoSolicitacaoEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "solicitacoes")
public class Solicitacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long solicitacaoId;

    @Enumerated(EnumType.STRING)
    private TipoSolicitacaoEnum tipo;

    @Enumerated(EnumType.STRING)
    private StatusSolicitacaoEnum status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "atendente_id")
    private Atendente atendente;

}

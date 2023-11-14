package com.ubots.avaliacao.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SolicitacaoDTO {
    private Long id;
    private String status;
    private String nomeAtendente;
    private String statusSolicitacao;
    private String tipoSolicitacao;
}

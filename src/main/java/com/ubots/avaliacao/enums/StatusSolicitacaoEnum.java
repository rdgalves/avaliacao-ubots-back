package com.ubots.avaliacao.enums;

import lombok.Getter;

@Getter
public enum StatusSolicitacaoEnum {
    PENDENTE("Pendente"),
    EM_ATENDIMENTO("Em Atendimento"),
    CONCLUIDA("Concluída");

    private final String descricao;

    StatusSolicitacaoEnum(String descricao) {
        this.descricao = descricao;
    }

}

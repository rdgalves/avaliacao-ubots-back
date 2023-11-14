package com.ubots.avaliacao.enums;

import lombok.Getter;

@Getter
public enum TipoSolicitacaoEnum {
    PROBLEMAS_COM_CARTAO("Problemas com cartão"),
    CONTRATACAO_EMPRESTIMO("contratação de empréstimo"),
    OUTROS("Outros");

    private final String descricao;

    TipoSolicitacaoEnum(String descricao) {
        this.descricao = descricao;
    }

}

package com.ubots.avaliacao.enums;

import lombok.Getter;

@Getter
public enum EquipeEnum {
    CARTOES("Cartões"),

    EMPRESTIMOS("Empréstimos"),

    OUTROS_ASSUNTOS("Outros Assuntos");

    private final String descricao;

    EquipeEnum(String descricao) {
        this.descricao = descricao;
    }

}

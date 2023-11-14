package com.ubots.avaliacao.model;

import com.ubots.avaliacao.enums.EquipeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "fila_solicitacoes")
public class Fila {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long filaId;

    private Long solicitacaoId;

    @Enumerated(EnumType.STRING)
    private EquipeEnum equipe;

    private LocalDateTime dataHoraEnfileiramento;

}

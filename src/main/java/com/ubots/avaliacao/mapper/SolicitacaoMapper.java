package com.ubots.avaliacao.mapper;

import com.ubots.avaliacao.dto.SolicitacaoDTO;
import com.ubots.avaliacao.model.Solicitacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SolicitacaoMapper {

    SolicitacaoMapper INSTANCE = Mappers.getMapper(SolicitacaoMapper.class);

    @Mapping(source = "status", target = "status")
    @Mapping(source = "solicitacaoId", target = "id")
    @Mapping(source = "atendente.nome", target = "nomeAtendente", defaultValue = "N/A")
    @Mapping(source = "status", target = "statusSolicitacao")
    @Mapping(source = "tipo", target = "tipoSolicitacao")
    SolicitacaoDTO solicitacaoToSolicitacaoDTO(Solicitacao solicitacao);
}

package com.ubots.avaliacao.repository;

import com.ubots.avaliacao.enums.EquipeEnum;
import com.ubots.avaliacao.model.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, Long> {
    List<Atendente> findByEquipe(EquipeEnum equipe);
}

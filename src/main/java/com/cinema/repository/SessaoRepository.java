package com.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinema.model.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long> {
	
	@Query("SELECT p FROM Usuario p WHERE p.email =:email")
	List<String> retornaHorarioSessao (@Param("inicio") String inicio);
}

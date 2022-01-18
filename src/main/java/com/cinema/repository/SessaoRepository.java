package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.model.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long> {

}

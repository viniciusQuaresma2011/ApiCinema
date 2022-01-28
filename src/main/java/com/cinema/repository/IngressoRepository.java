package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.model.Ingresso;

@Repository
public interface IngressoRepository extends JpaRepository<Ingresso, Long> {

}

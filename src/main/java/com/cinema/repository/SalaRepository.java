package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.model.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

}

package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinema.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

}

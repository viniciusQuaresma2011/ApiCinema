package com.cinema.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cinema.model.Usuario;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}

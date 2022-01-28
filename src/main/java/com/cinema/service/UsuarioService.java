package com.cinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.model.Usuario;
import com.cinema.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	

	public List<Usuario> findAllUsers(){
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	
	public Usuario createUser(Usuario usuario) {
				return usuarioRepository.save(usuario);
	}
	
	public Usuario getUserById(Long id) {
		return usuarioRepository.findById(id).get();
	}
	
	public void deleteUser(Long id) {
		usuarioRepository.deleteById(id);
	}
	
}

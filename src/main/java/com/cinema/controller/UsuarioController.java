package com.cinema.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.model.Usuario;
import com.cinema.service.UsuarioService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")

public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}

	@GetMapping("/cadastro/usuario/listar")
	public List<Usuario> getAllUsers() {
		return usuarioService.findAllUsers();
	}

	@PostMapping(value="/cadastro/usuario/salvar", consumes = {"application/json"})
	public Usuario createUser(@RequestBody @Valid Usuario usuario) throws Exception {

		if(usuario == null) {
			throw new Exception("Usuario Vazio");
		}
			
		return usuarioService.createUser(usuario);
	}
	
	@GetMapping(value="/cadastro/usuario/{id}", consumes={"application/json"})
	public ResponseEntity<Usuario> getUserById(@PathVariable Long id) throws Exception{
		Usuario usuario = usuarioService.getUserById(id);
		if(usuario == null) {
				throw new Exception("Usuario Nao encontrado de acordo com id"+ id);
		}
		
		return ResponseEntity.ok(usuario);
	}
	
	@PutMapping(value="/cadastro/usuario/editar/{id}" , consumes = {"application/json"})
	public ResponseEntity<Usuario> editUserById(@PathVariable("id") Long id, @RequestBody  Usuario usuario) throws Exception {
		Usuario usuarioLocalizar = usuarioService.getUserById(id);
		if(usuarioLocalizar == null) {
			throw new Exception("Usuario Nao encontrado de acordo com id"+ id);
		}
		
		usuarioLocalizar.setNome(usuario.getNome());
		usuarioLocalizar.setEmail(usuario.getEmail());
		usuarioLocalizar.setTelefone(usuario.getTelefone());
		usuarioLocalizar.setEndereco(usuario.getEndereco());
		
		Usuario usuarioAtualizado = usuarioService.createUser(usuarioLocalizar);
		return ResponseEntity.ok(usuarioAtualizado);
	}
	
	
	@DeleteMapping("/cadastro/usuario/remover/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUserById(@PathVariable Long id) throws Exception{
		Usuario usuario = usuarioService.getUserById(id);
		if(usuario == null) {
			throw new Exception("Usuario nao encontrado" + id);
		}
		
		usuarioService.deleteUser(id);
		Map<String, Boolean> responseAwait  = new HashMap<>();
		responseAwait.put("Deleted Succesfully!", Boolean.TRUE);
		return ResponseEntity.ok(responseAwait);
		
	}
	

}

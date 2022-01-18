package com.cinema.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cinema.model.Sala;
import com.cinema.model.Sessao;
import com.cinema.repository.SalaRepository;
import com.cinema.repository.SessaoRepository;
import com.cinema.service.SessaoService;

@RestController
public class SessaoController {
	
	@Autowired
	private SessaoService sessaoService;

	@Autowired
	private SessaoRepository sessaoRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	
	public SessaoController(SessaoService sessaoService) {
		super();
		this.sessaoService = sessaoService;
	}
	
	@GetMapping("/cadastro/sessao/listar")
	public List<Sessao> getAllSessions(){
		return sessaoService.findAllSessions();
	}
	
	@PostMapping("/cadastro/sessao/salvar")
	public Sessao createSession(@RequestBody @Valid  Sessao sessao) {
		return sessaoService.createSession(sessao);
	}
	
	
	@GetMapping("/cadastro/sessao/{id}")
	public ResponseEntity<Sessao> getSessionById(@PathVariable Long id){
		Sessao sessao = sessaoService.getSessionById(id);
		return ResponseEntity.ok(sessao);
	}
	
	@PutMapping("/cadastro/sessao/editar/{id}")
	public ResponseEntity<Sessao> editSessionById(@PathVariable("id") Long id, @RequestBody @Valid Sessao sessao) throws Exception{
	
		
		
		Sessao opcionalSessao = sessaoService.getSessionById(id);
		if(opcionalSessao == null) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		opcionalSessao.setNome(sessao.getNome());
		opcionalSessao.setHorario(sessao.getHorario());
		opcionalSessao.setDisponibilidade(sessao.getDisponibilidade());
	
		
		Sessao sessaoAtualizadao = sessaoService.createSession(opcionalSessao);
		
		
		return ResponseEntity.ok(sessaoAtualizadao);
	}
	
	@DeleteMapping("/cadastro/sessao/remover/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSessionById(@PathVariable Long id){
		
		sessaoService.deleteSession(id);
		Map<String, Boolean> responseAwait = new HashMap<>();
		responseAwait.put("Removido Com Sucesso", Boolean.TRUE);
		return ResponseEntity.ok(responseAwait);
		
	}
	
}

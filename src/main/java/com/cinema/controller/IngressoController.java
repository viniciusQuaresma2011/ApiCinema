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

import com.cinema.model.Ingresso;
import com.cinema.service.IngressoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class IngressoController {
	
	
	@Autowired
	private IngressoService ingressoService;

	public IngressoController(IngressoService ingressoService) {
		super();
		this.ingressoService = ingressoService;
	}
	
	@GetMapping("/cadastro/ingresso/listar")
	public List<Ingresso> getAllTickets(){
		return ingressoService.findAllTickets();
	}
	
	@PostMapping("/cadastro/ingresso/salvar")
	public ResponseEntity<Ingresso> createTicket(@RequestBody @Valid Ingresso ingresso) throws Exception  {
		Ingresso ingressoNovo = ingressoService.createTicket(ingresso);
		
		return ResponseEntity.ok(ingressoNovo);
	}
	
	@GetMapping("/cadastro/ingresso/{id}")
	public ResponseEntity<Ingresso> getTicketById(@PathVariable Long id) throws Exception{
		Ingresso ingresso = ingressoService.getTicketById(id);
		if(ingresso == null) {
			throw new Exception("Ingresso nao encontrado " + id);
		}
		return ResponseEntity.ok(ingresso);
	}
	
	@PutMapping("/cadastro/ingresso/editar/{id}")
	public ResponseEntity<Ingresso> editTicketById(@PathVariable("id") Long id, @RequestBody Ingresso ingresso) throws Exception{
		Ingresso localizarIngresso = ingressoService.getTicketById(id);
		if(localizarIngresso == null) {
			throw new Exception("Ingresso nao encontrado" + id);
		}
		
		localizarIngresso.setData_compra(ingresso.getData_compra());
		localizarIngresso.setSessao(ingresso.getSessao());
		localizarIngresso.setValor(ingresso.getValor());
	
		
		
		Ingresso ingressoAtualizado = ingressoService.createTicket(localizarIngresso);
		return ResponseEntity.ok(ingressoAtualizado);
	}
	
	@DeleteMapping("/cadastro/ingresso/remover/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTicketById(@PathVariable Long id) throws Exception{
		Ingresso ingresso = ingressoService.getTicketById(id);
		if(ingresso == null) {
			throw new Exception("Ingresso nao encontrado" + id);
		}
		
		ingressoService.deleteTicket(id);
		Map<String, Boolean> responseAwait = new HashMap<>();
		responseAwait.put("Removido Com  Sucesso", Boolean.TRUE);
		return ResponseEntity.ok(responseAwait);
	}
	
}

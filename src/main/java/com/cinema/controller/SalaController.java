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
import com.cinema.repository.SalaRepository;
import com.cinema.service.SalaService;

@RestController
public class SalaController {

		@Autowired
		private SalaService salaService;
		
		@Autowired
		private SalaRepository salaRepository;

		public SalaController(SalaService salaService) {
			super();
			this.salaService = salaService;
		}
		
		@GetMapping("/cadastro/sala/listar")
		public List<Sala> getAllRooms(){
			return salaService.findAllRooms();
		}
		
		@PostMapping("/cadastro/sala/salvar")
		public Sala createRoom(@Valid @RequestBody Sala sala){
			return salaService.createRoom(sala);
		}
		
		
		@GetMapping("/cadastro/sala/{id}")
		public ResponseEntity<Sala> getRoomById(@PathVariable Long id) throws Exception{
			Sala sala = salaService.getRoomById(id);
			if(sala == null) {
				throw new Exception("Sala nao encontrada" + id);
			}
			return ResponseEntity.ok(sala);
		}
		
		@PutMapping("/cadastro/sala/editar/{id}")
		public ResponseEntity<Sala> editRoomById(@PathVariable("id") Long id, @Valid @RequestBody Sala sala) throws Exception{
			Sala opcionalSala = salaService.getRoomById(id);
			if(opcionalSala == null) {
				throw new Exception("Sala nao encontrada" + id);
			}
			
			opcionalSala.setNome(sala.getNome());
	
			Sala salaAtualizada = salaService.createRoom(opcionalSala);
			
			
			return ResponseEntity.ok(salaAtualizada);
			
		}
		
		@DeleteMapping("/cadastro/sala/remover/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteRoomById(@PathVariable Long id) throws Exception{
			Sala sala = salaService.getRoomById(id);
			if(sala == null) {
				throw new Exception("Sala nao Encontrada" + id);
			}
			
			
			salaService.deleteRoom(id);
			Map<String, Boolean> responseAwait = new HashMap<>();
			responseAwait.put("Removido Com Sucesso", Boolean.TRUE);
			return ResponseEntity.ok(responseAwait);
		}
		
}

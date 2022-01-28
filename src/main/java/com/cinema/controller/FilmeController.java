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

import com.cinema.model.Filme;
import com.cinema.repository.FilmeRepository;
import com.cinema.service.FilmeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class FilmeController {
	
	
	@Autowired
	private FilmeService filmeService;
	

	
	@Autowired
	private FilmeRepository filmeRepository;
	
	
	public FilmeController(FilmeService filmeService) {
		super();
		this.filmeService = filmeService;
	}
	
	@GetMapping("/cadastro/filme/listar")
	public List<Filme> getAllMovies(){
		return filmeService.findAllMovies();
	}
	
	@PostMapping("/cadastro/filme/salvar")
	public ResponseEntity<Filme> createMovie(@RequestBody @Valid Filme filme) throws Exception {
		//String dia = filme.get
		
		
		Filme f = filmeService.createMovie(filme);
		return ResponseEntity.ok(f);
	}
	
	@GetMapping("/cadastro/filme/{id}")
	public ResponseEntity<Filme> getMovieById(@PathVariable Long id) throws Exception{
		Filme filme = filmeService.getMovieById(id);
		if(filme == null) {
			throw new Exception("Filme nao encontrado pelo id" + id);
		}
		
		return ResponseEntity.ok(filme);
		
	}
	
	@PutMapping("/cadastro/filme/editar/{id}")
	public ResponseEntity<Filme>  editMovieById(@PathVariable("id") Long id, @RequestBody @Valid Filme filme) throws Exception{
		
		
		Filme opcionalFilme = filmeService.getMovieById(id);		
		if(opcionalFilme == null) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		opcionalFilme.setNome(filme.getNome());
		opcionalFilme.setData_estreia(filme.getData_estreia());
		opcionalFilme.setDuracao(filme.getDuracao());
		opcionalFilme.setDirecao(filme.getDirecao());
		opcionalFilme.setOrigem(filme.getOrigem());
		opcionalFilme.setDublagem(filme.getDublagem());
		opcionalFilme.setTipo(filme.getTipo());

		
		Filme novoFilme = filmeService.createMovie(opcionalFilme);
		return ResponseEntity.ok(novoFilme);
		
		
	}
	
	@DeleteMapping("/cadastro/filme/remover/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMovieById(@PathVariable Long id) throws Exception{
		Filme filme = filmeService.getMovieById(id);
		if(filme == null) {
			throw new Exception("Filme nao encontrado" + id);
		}
		
		filmeService.deleteMovie(id);
		Map<String, Boolean> responseAwait = new HashMap<>();
		responseAwait.put("Removido Com Sucesso", Boolean.TRUE);
		return ResponseEntity.ok(responseAwait);
	}
	
	
}

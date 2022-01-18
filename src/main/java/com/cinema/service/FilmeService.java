package com.cinema.service;

import java.util.List;


import org.springframework.stereotype.Service;


import com.cinema.model.Filme;
import com.cinema.repository.FilmeRepository;

@Service
public class FilmeService {
	
	
	
	private FilmeRepository filmeRepository;

	public FilmeService(FilmeRepository filmeRepository) {
		super();
		this.filmeRepository = filmeRepository;
	}
	
	

	public List<Filme> findAllMovies(){
		return (List<Filme>) filmeRepository.findAll();
	}
	
	public Filme createMovie(Filme filme) {
		return filmeRepository.save(filme);
	}
	
	public Filme getMovieById(Long id) {
		return filmeRepository.findById(id).get();
	}
	
	public void deleteMovie(Long id) {
		filmeRepository.deleteById(id);
	}
	
	
	
	
	
}

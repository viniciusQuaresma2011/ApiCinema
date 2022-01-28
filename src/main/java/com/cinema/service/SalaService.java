package com.cinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.model.Sala;
import com.cinema.repository.SalaRepository;

@Service
public class SalaService {
	
	
	private SalaRepository salaRepository;

	public SalaService(SalaRepository salaRepository) {
		super();
		this.salaRepository = salaRepository;
	}
	
	public List<Sala> findAllRooms(){
		return (List<Sala>) salaRepository.findAll();
	}
	
	
	public Sala createRoom(Sala sala) {
		return salaRepository.save(sala);
	}
	
	public Sala getRoomById(Long id) {
		return salaRepository.findById(id).get();
	}
	
	public void deleteRoom(Long id) {
		salaRepository.deleteById(id);
	}
	
}

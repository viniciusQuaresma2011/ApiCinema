package com.cinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.model.Ingresso;
import com.cinema.repository.IngressoRepository;

@Service
public class IngressoService {
	
	private IngressoRepository ingressoRepository;

	public IngressoService(IngressoRepository ingressoRepository) {
		super();
		this.ingressoRepository = ingressoRepository;
	}
	
	public List<Ingresso> findAllTickets(){
		return (List<Ingresso>) ingressoRepository.findAll();
	}
	
	public Ingresso createTicket(Ingresso ingresso) throws Exception {
		if(ingresso == null) {
			throw new Exception("Ingresso vazio");
		}
		return ingressoRepository.save(ingresso);
	}
	
	public Ingresso getTicketById(Long id) {
		return ingressoRepository.findById(id).get();
	}
	
	public void deleteTicket(Long id) {
		ingressoRepository.deleteById(id);
	}
}

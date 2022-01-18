package com.cinema.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.model.Sessao;
import com.cinema.repository.SessaoRepository;

@Service
public class SessaoService {
	
	
	private SessaoRepository sessaoRepository;

	public SessaoService(SessaoRepository sessaoRepository) {
		super();
		this.sessaoRepository = sessaoRepository;
	}
	
	public List<Sessao> findAllSessions(){
		return  (List<Sessao>)sessaoRepository.findAll();
	}
	
	public Sessao createSession(Sessao sessao) {
		return sessaoRepository.save(sessao);
	}
	
	public Sessao getSessionById(Long id) {
		return sessaoRepository.findById(id).get();
	}
	
	public void deleteSession(Long id) {
		sessaoRepository.deleteById(id);
	}
	
	
	
}

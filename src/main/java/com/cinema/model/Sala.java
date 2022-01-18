package com.cinema.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="sala")
public class Sala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_sala;
	
	@Column(unique = true)
	@NotBlank(message = "Favor informar o nome")
	private String nome;
//	
//	@OneToMany(mappedBy = "salas", cascade = CascadeType.ALL)
//	private Set<Sessao> sessao = new HashSet<>();
	

	public Sala() {
		super();
	}

	public Sala(Long id_sala, String nome) {
		super();
		this.id_sala = id_sala;
		this.nome = nome;
		
	}

	public Long getId_sala() {
		return id_sala;
	}

	public void setId_sala(Long id_sala) {
		this.id_sala = id_sala;
	}

	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

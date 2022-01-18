package com.cinema.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="sessao")
public class Sessao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_sessao;
	
	@Column(unique=true)
	@NotEmpty
	@NotBlank(message = "Favor informar o nome")
	private String nome;
	
	@Column(unique=true)
	@NotEmpty
	@NotBlank(message = "Favor informar o horario")
	private String horario;
	
	@Column
	@NotEmpty
	@NotBlank(message = "Favor informar a disponibilidade")
	private String disponibilidade;
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JsonProperty(access = JsonProperty.Access.AUTO)
//	private Sala salas;
	
	
	public Sessao() {
		super();
	}

	public Sessao(Long id_sessao, String nome, String horario, String disponibilidade){
		super();
		this.id_sessao = id_sessao;
		this.nome = nome;
		this.horario = horario;
		this.disponibilidade = disponibilidade;
	
	}


	public Long getId_sessao() {
		return id_sessao;
	}


	public void setId_sessao(Long id_sessao) {
		this.id_sessao = id_sessao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHorario() {
		return horario;
	}
	
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
	public String getDisponibilidade() {
		return disponibilidade;
	}



	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	
	
}

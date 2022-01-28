package com.cinema.model;


import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="sessao")
public class Sessao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_sessao;
	
	@Column
	private String inicio;
	
	@Column
	private String fim;
	
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Filme filme;
	
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Sala sala;
	
	
	@Column
	@NotBlank(message="favor preencher o valor da sessao")
	private String valor_sessao;

	
	public Sessao() {
		super();
	}
	
	public Sessao(Long id_sessao, String inicio, String fim, Filme filme, Sala sala, String valor_sessao) {
		super();
		this.id_sessao = id_sessao;
		this.inicio = inicio;
		this.fim = fim;
		this.filme = filme;
		this.sala = sala;
		this.valor_sessao = valor_sessao;
	}


	public Long getId_sessao() {
		return id_sessao;
	}


	public void setId_sessao(Long id_sessao) {
		this.id_sessao = id_sessao;
	}


	public String getInicio() {
		return inicio;
	}


	public void setInicio(String inicio) {
		this.inicio = inicio;
	}


	public String getFim() {
		return fim;
	}


	public void setFim(String fim) {
		this.fim = fim;
	}


	public Filme getFilme() {
		return filme;
	}


	public void setFilme(Filme filme) {
		this.filme = filme;
	}


	public Sala getSala() {
		return sala;
	}


	public void setSala(Sala sala) {
		this.sala = sala;
	}


	public String getValor_sessao() {
		return valor_sessao;
	}


	public void setValor_sessao(String valor_sessao) {
		this.valor_sessao = valor_sessao;
	}
	
	
	
}

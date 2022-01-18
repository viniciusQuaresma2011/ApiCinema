package com.cinema.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="ingresso")
public class Ingresso  implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1454663849268826246L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ingresso;
	
	@Column
	private String situacao;
	
	
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Usuario usuario;
	
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Filme filme;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Sessao sessao;
	
	
//	@ManyToOne
//	@PrimaryKeyJoinColumn
//	private Sala sala;
	
	@Column
	@NotNull(message = "Favor informar a data")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate data;
	
	@Column
	@NotNull(message = "Favor informar o horario")
	private LocalTime horario;
	
	



	public Ingresso() {
		super();
	}

	public Ingresso(Long id_ingresso, String situacao,Usuario usuario, LocalDate data, LocalTime horario, Filme filme, Sessao sessao) {
		super();
		this.id_ingresso = id_ingresso;
		this.usuario = usuario;
		this.data = data;
		this.horario = horario;
		this.filme = filme;
		this.sessao = sessao;
		this.situacao = situacao;
	}



	public Long getId_ingresso() {
		return id_ingresso;
	}

	public void setId_ingresso(Long id_ingresso) {
		this.id_ingresso = id_ingresso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

	

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}



	
	
}

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
	@NotBlank(message = "Favor informar a quantidade de pessoas")
	private String quantidade_pessoas;

	

	public Sala() {
		super();
	}



	public Sala(Long id_sala, String quantidade_pessoas) {
		super();
		this.id_sala = id_sala;
		this.quantidade_pessoas = quantidade_pessoas;
	}



	public Long getId_sala() {
		return id_sala;
	}



	public void setId_sala(Long id_sala) {
		this.id_sala = id_sala;
	}



	public String getQuantidade_pessoas() {
		return quantidade_pessoas;
	}



	public void setQuantidade_pessoas(String quantidade_pessoas) {
		this.quantidade_pessoas = quantidade_pessoas;
	}

	
	

}

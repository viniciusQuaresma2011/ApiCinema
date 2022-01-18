package com.cinema.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="usuario")
public class Usuario {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	
	@Column
	@NotEmpty(message = "Campo nao informado")
	private String nome;
	
	@Column(unique=true)
	@Email
	//@NotEmpty(message = "Campo nao informado")
	private String email;
	
	@Column(unique=true)
	@NotNull(message = "Campo nao informado")
	private String telefone;
	
	@OneToOne( cascade = CascadeType.ALL)
	private Endereco endereco;
	
	
	
	public Usuario() {
		super();
	}


	public Usuario(Long id_usuario, String nome, String email, String telefone, Endereco endereco) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	
}

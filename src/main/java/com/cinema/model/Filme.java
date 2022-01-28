package com.cinema.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="filme")
public class Filme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_filme;
	
	@Column(unique=true)
	@NotEmpty
	@NotBlank(message = "Favor preencher o nome")
	private String nome;
	
	@Column(unique=true)
	private LocalDate data_estreia;
	
	@Column(unique=true)
	@NotEmpty
	@NotBlank(message = "Favor preencher a duracao")
	private String duracao;
	
	@Column(unique=true)
	@NotEmpty
	@NotBlank(message = "Favor preencher a direcao")
	private String direcao;
	
	@Column(unique=true)
	@NotEmpty
	@NotBlank(message="Favor preencher a origem")
	private String origem;
	
	@Column(unique=true)
	@NotEmpty
	@NotBlank(message = "Favor preencher a dublagem")
	private String dublagem;
	
	@Column(unique=true)
	@NotEmpty
	@NotBlank(message = "Favor preencher o tipo")
	private String tipo;
	
	
	
	
	public Filme() {
		super();
	}




	public Filme(Long id_filme, String nome, LocalDate data_estreia, String duracao, String direcao, String origem,
			String dublagem, String tipo) {
		super();
		this.id_filme = id_filme;
		this.nome = nome;
		this.data_estreia = data_estreia;
		this.duracao = duracao;
		this.direcao = direcao;
		this.origem = origem;
		this.dublagem = dublagem;
		this.tipo = tipo;
	}




	public Long getId_filme() {
		return id_filme;
	}




	public void setId_filme(Long id_filme) {
		this.id_filme = id_filme;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public LocalDate getData_estreia() {
		return data_estreia;
	}




	public void setData_estreia(LocalDate data_estreia) {
		this.data_estreia = data_estreia;
	}




	public String getDuracao() {
		return duracao;
	}




	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}




	public String getDirecao() {
		return direcao;
	}




	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}




	public String getOrigem() {
		return origem;
	}




	public void setOrigem(String origem) {
		this.origem = origem;
	}




	public String getDublagem() {
		return dublagem;
	}




	public void setDublagem(String dublagem) {
		this.dublagem = dublagem;
	}




	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	
}

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
	@NotEmpty
	@NotBlank(message = "Favor preencher o ano de lancamento")
	private String ano_lancamento;
	
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

	public Filme(Long id_filme, @NotEmpty String nome, @NotEmpty String ano_lancamento, @NotEmpty String duracao,
			@NotEmpty String direcao, @NotEmpty String origem, @NotEmpty String dublagem, @NotEmpty String tipo
			) {
		super();
		this.id_filme = id_filme;
		this.nome = nome;
		this.ano_lancamento = ano_lancamento;
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

	public String getAno_lancamento() {
		return ano_lancamento;
	}

	public void setAno_lancamento(String ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
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

package com.cinema.model;


import java.time.LocalDate;


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
@Table(name="ingresso")
public class Ingresso  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ingresso;
	
	@Column
	private LocalDate data_compra;
	
	@Column
	@NotBlank(message="favor preencher o valor")
	private String valor;
	
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="id_sessao_fk")
	private Sessao sessao;
	
	public Ingresso() {
		super();
	}

	public Ingresso(Long id_ingresso, LocalDate data_compra, String valor, Sessao sessao) {
		super();
		this.id_ingresso = id_ingresso;
		this.data_compra = data_compra;
		this.valor = valor;
		this.sessao = sessao;
	}


	public Long getId_ingresso() {
		return id_ingresso;
	}


	public void setId_ingresso(Long id_ingresso) {
		this.id_ingresso = id_ingresso;
	}


	public LocalDate getData_compra() {
		return data_compra;
	}


	public void setData_compra(LocalDate data_compra) {
		this.data_compra = data_compra;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	public Sessao getSessao() {
		return sessao;
	}


	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
	



	
}

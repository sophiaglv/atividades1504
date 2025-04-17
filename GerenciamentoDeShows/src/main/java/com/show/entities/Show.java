package com.show.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "shows")
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Informe o nome do artista!")
	private String nomeArtista;
	
	@Min(value = 1, message = "Tempo mínimo é 1 hora")
	@Max(value = 4, message = "Tempo máximo é 4 horas")
	private double tempo;
	
	@NotNull(message = "Informe o valor do ingresso!")
	private double preco;
	
	@Min(value = 12, message = "A idade mínima é 12 anos")
	private int idade;
	
	@FutureOrPresent
	private Date dataDoShow;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeArtista() {
		return nomeArtista;
	}

	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}

	public double getTempo() {
		return tempo;
	}

	public void setTempo(double tempo) {
		this.tempo = tempo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Date getDataDoShow() {
		return dataDoShow;
	}

	public void setDataDoShow(Date dataDoShow) {
		this.dataDoShow = dataDoShow;
	}
	
	
}

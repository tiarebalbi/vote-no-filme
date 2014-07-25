package com.tiarebalbi.entity;

import javax.persistence.Entity;

import org.springframework.util.Assert;


/**
 * Entidade de Filme
 * @author Tiarê Balbi Bonamini
 */

@Entity
public class Filme extends BaseEntity {
	
	private String nome;
	
	private String capa;
	
	private String descricao;
	
	protected Filme() {}

	/**
	 * Criação de um novo {@link Filme}
	 * 
	 * @param nome não deve ser {@literal null} ou em branco
	 */
	public Filme(String nome) {
		Assert.hasText(nome, "O nome do filme não pode ficar em branco!");
		
		this.nome = nome;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the capa
	 */
	public String getCapa() {
		return capa;
	}

	/**
	 * @param capa the capa to set
	 */
	public void setCapa(String capa) {
		this.capa = capa;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return String.format("Filme[id=%d, nome='%s', descricao='%s', capa='%s']", id, nome, descricao, capa);
	}
	
}

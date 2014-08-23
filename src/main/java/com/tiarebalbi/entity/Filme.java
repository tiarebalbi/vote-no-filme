package com.tiarebalbi.entity;

import javax.persistence.Entity;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnore;
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
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
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

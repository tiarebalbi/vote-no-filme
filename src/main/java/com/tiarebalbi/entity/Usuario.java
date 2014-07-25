package com.tiarebalbi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

/**
 * @author Tiarê Balbi Bonamini
 *
 */
@Entity
public class Usuario extends BaseEntity {

	private String nome;
	
	@Column(unique=true)
	private String email;
	
	@ElementCollection
	private List<String> sessoes = new ArrayList<>();
	
	private Boolean status;
	
	protected Usuario () {}
	

	/**
	 * @param nome Nome do usuário {@link String}
	 * @param email E-Mail do usuário {@link String} (O e-mail deve ser único)
	 */
	public Usuario(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	
	/**
	 * Consulta a lista de sessões que o usuário utilizou para votar
	 * 
	 * @return {@link List} 
	 */
	public List<String> getSessoes() {
		return sessoes;
	}
	
	/**
	 * @param sessao
	 */
	public void addSessao(String sessao) {
		if(this.sessoes == null ) {
			this.sessoes = new ArrayList<>();
		}
		
		this.sessoes.add(sessao);
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * metodo getter do attr. status
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}

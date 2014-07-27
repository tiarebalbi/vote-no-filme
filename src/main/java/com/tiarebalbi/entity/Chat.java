package com.tiarebalbi.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Tiarê Balbi Bonamini
 */
@Entity
public class Chat extends BaseEntity {

	private String mensagem;
	
	@ManyToOne
	private Usuario usuario;

	/**
	 * metodo getter do attr. mensagem
	 * @return the mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * @param mensagem the mensagem to set
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	/**
	 * metodo getter do attr. usuario
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}

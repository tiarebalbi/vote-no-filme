package com.tiarebalbi.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Entidade para registro dos votos
 * 
 * @author Tiarê Balbi Bonamini
 */
@Entity
public class Voto extends BaseEntity {

	private String session;
	
	@ManyToOne
	private Filme filme;

	/**
	 * @return the session
	 */
	public String getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(String session) {
		this.session = session;
	}

	/**
	 * @return the filme
	 */
	public Filme getFilme() {
		return filme;
	}

	/**
	 * @param filme the filme to set
	 */
	public void setFilme(Filme filme) {
		this.filme = filme;
	}

}

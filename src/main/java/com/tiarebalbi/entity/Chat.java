package com.tiarebalbi.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Tiarê Balbi Bonamini
 */
@Entity
public class Chat extends BaseEntity {

	private String mensagem;
	
	@ManyToOne
	private Usuario usuario;
	
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	private Calendar horario;

	/**
	 * @return the horario
	 */
	public Calendar getHorario() {
		return horario;
	}

	/**
	 * @param horario the horario to set
	 */
	public void setHorario(Calendar horario) {
		this.horario = horario;
	}

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
	
	
	@Override
	public String toString() {
		return String.format("[%s] Mensagem: %s", getHorario().getTime() ,getMensagem() );
	}
}

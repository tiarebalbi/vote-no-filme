package com.tiarebalbi.domain.dto;

import com.mysema.query.annotations.QueryProjection;

public class RankFilmeDTO {
	
	private String filme;
	
	private Integer totalVotos;
	
	@QueryProjection
	public RankFilmeDTO(String filme, Integer totalVotos) {
		super();
		this.filme = filme;
		this.totalVotos = totalVotos;
	}

	/**
	 * metodo getter do attr. filme
	 * @return the filme
	 */
	public String getFilme() {
		return filme;
	}

	/**
	 * metodo getter do attr. totalVotos
	 * @return the totalVotos
	 */
	public Integer getTotalVotos() {
		return totalVotos;
	}
	
}

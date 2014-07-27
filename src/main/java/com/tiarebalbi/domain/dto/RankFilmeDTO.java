package com.tiarebalbi.domain.dto;

import com.mysema.query.annotations.QueryProjection;

/**
 * @author Tiarê Balbi Bonamini
 */
public class RankFilmeDTO {
	
	private String filme;
	
	private Long totalVotos;
	
	/**
	 * @param filme
	 * @param totalVotos
	 */
	@QueryProjection
	public RankFilmeDTO(String filme, Long totalVotos) {
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
	public Long getTotalVotos() {
		return totalVotos;
	}
	
	
	@Override
	public String toString() {
		return String.format("RankFilmeDTO[filme='%s', total='%d']", filme, totalVotos);
	}
}

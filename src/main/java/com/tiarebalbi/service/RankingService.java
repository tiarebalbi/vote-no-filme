package com.tiarebalbi.service;

import java.util.List;

import com.tiarebalbi.domain.dto.RankFilmeDTO;
import com.tiarebalbi.entity.Usuario;

/**
 * @author Tiarê Balbi Bonamini
 */
public interface RankingService {
	
	/**
	 * Busca o rank de filmes e o total de votos
	 * 
	 * @return {@link List}
	 */
	List<RankFilmeDTO> buscarRankGeral();
	
	/**
	 * Busca o rank de filmes votados pelo o {@link Usuario}
	 * 
	 * @param usuario
	 * @return {@link List}
	 */
	List<RankFilmeDTO> buscarRank(Usuario usuario);

}

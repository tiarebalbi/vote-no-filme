package com.tiarebalbi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.tiarebalbi.domain.dto.RankFilmeDTO;
import com.tiarebalbi.entity.Usuario;
import com.tiarebalbi.query.VotoQuery;

/**
 * @author Tiarê Balbi Bonamini
 */
@Service
@Transactional
public class CustomRankingService implements RankingService {
	
	private final VotoQuery query;
	
	/**
	 * @param query {@link VotoQuery}
	 */
	@Autowired
	public CustomRankingService(VotoQuery query) {
		this.query = query;
	}
	

	@Override
	public List<RankFilmeDTO> buscarRankGeral() {
		return this.query.buscarRankGeral();
	}

	@Override
	public List<RankFilmeDTO> buscarRank(Usuario usuario) {
		Assert.notNull(usuario, "Não foi possível identificar as informações sobre o usuário");
		return this.query.buscarRankPorUsuario(usuario);
	}

}

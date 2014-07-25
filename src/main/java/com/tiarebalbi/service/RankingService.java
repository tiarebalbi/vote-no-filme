package com.tiarebalbi.service;

import java.util.List;

import com.tiarebalbi.domain.dto.RankFilmeDTO;
import com.tiarebalbi.entity.Usuario;

public interface RankingService {
	
	List<RankFilmeDTO> buscarRank();
	
	List<RankFilmeDTO> buscarRank(Usuario usuario);

}

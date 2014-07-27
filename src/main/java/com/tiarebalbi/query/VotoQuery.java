package com.tiarebalbi.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.mysema.query.jpa.impl.JPAQuery;
import com.tiarebalbi.domain.dto.QRankFilmeDTO;
import com.tiarebalbi.domain.dto.RankFilmeDTO;
import com.tiarebalbi.entity.QVoto;
import com.tiarebalbi.entity.Usuario;

/**
 * @author Tiarê Balbi Bonamini
 */
@Repository
public class VotoQuery {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * @return {@link List}
	 */
	public List<RankFilmeDTO> buscarRankGeral() {
		JPAQuery query = new JPAQuery(em);
		QVoto entidade = QVoto.voto;
		return query.from(entidade)
					.groupBy(entidade.filme.nome)
					.orderBy(entidade.filme.nome.count().desc())
					.list(new QRankFilmeDTO(entidade.filme.nome, entidade.filme.nome.count()));
	}
	
	/**
	 * @param usuario {@link Usuario}
	 * @return {@link List}
	 */
	public List<RankFilmeDTO> buscarRankPorUsuario(Usuario usuario) {
		JPAQuery query = new JPAQuery(em);
		
		QVoto entidade = QVoto.voto;
		return query.from(entidade)
					.groupBy(entidade.filme.nome)
					.orderBy(entidade.filme.nome.count().desc())
					.where(entidade.session.in(usuario.getSessoes()))
					.list(new QRankFilmeDTO(entidade.filme.nome, entidade.filme.nome.count()));
	}

}
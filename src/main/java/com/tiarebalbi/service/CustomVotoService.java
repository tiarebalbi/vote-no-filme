/**
 * 
 */
package com.tiarebalbi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import com.tiarebalbi.entity.Voto;
import com.tiarebalbi.repository.VotoRepository;

/**
 * @author Tiarê Balbi Bonamini
 *
 */
@Service
@Transactional
public class CustomVotoService implements VotoService {

	private final VotoRepository repository;
	
	/**
	 * @param repository {@link VotoRepository}
	 */
	@Autowired
	public CustomVotoService(VotoRepository repository) {
		this.repository = repository;
	}

	/* (non-Javadoc)
	 * @see com.tiarebalbi.service.VotoService#salvar(com.tiarebalbi.entity.Voto)
	 */
	@Override
	public Voto salvar(Voto voto) {
		Assert.notNull(voto, "Não foi possível identificar os dados do seu voto.");
		
		Assert.notNull(voto.getFilme(), "Não foi possível identificar o filme votado. Por favor tente votar novamente.");
		Assert.notNull(voto.getSession(), "Não foi possível identificar a sua sessão, por favor recarregue a página.");
		
		return this.repository.save(voto);
	}

	/* (non-Javadoc)
	 * @see com.tiarebalbi.service.VotoService#buscarTodos(com.mysema.query.types.Predicate, com.mysema.query.types.OrderSpecifier[])
	 */
	@Override
	public List<Voto> buscarTodos(Predicate condicao, OrderSpecifier<?>... ordem) {
		Assert.notNull(condicao, "Não foi possível identificar a condição de busca.");
		return (List<Voto>) this.repository.findAll(condicao, ordem);
	}

	/* (non-Javadoc)
	 * @see com.tiarebalbi.service.VotoService#buscarRegistro(com.mysema.query.types.Predicate)
	 */
	@Override
	public Voto buscarRegistro(Predicate condicao) {
		Assert.notNull(condicao, "Não foi possível identificar a condição de busca.");
		return this.repository.findOne(condicao);
	}

	/* (non-Javadoc)
	 * @see com.tiarebalbi.service.VotoService#buscarRegistro(java.lang.Long)
	 */
	@Override
	public Voto buscarRegistro(Long id) {
		Assert.notNull(id, "Não foi possível identificar a chave do registro solicitado.");
		return this.repository.findOne(id);
	}

}

/**
 * 
 */
package com.tiarebalbi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Autowired
	private VotoRepository repository;

	/* (non-Javadoc)
	 * @see com.tiarebalbi.service.VotoService#salvar(com.tiarebalbi.entity.Voto)
	 */
	@Override
	public Voto salvar(Voto voto) {
		// TODO Auto-generated method stub
		return this.repository.save(voto);
	}

	/* (non-Javadoc)
	 * @see com.tiarebalbi.service.VotoService#buscarTodos(com.mysema.query.types.Predicate, com.mysema.query.types.OrderSpecifier[])
	 */
	@Override
	public List<Voto> buscarTodos(Predicate condicao,
			OrderSpecifier<?>... ordem) {
		// TODO Auto-generated method stub
		return (List<Voto>) this.repository.findAll(condicao, ordem);
	}

	/* (non-Javadoc)
	 * @see com.tiarebalbi.service.VotoService#buscarRegistro(com.mysema.query.types.Predicate)
	 */
	@Override
	public Voto buscarRegistro(Predicate condicao) {
		// TODO Auto-generated method stub
		return this.repository.findOne(condicao);
	}

	/* (non-Javadoc)
	 * @see com.tiarebalbi.service.VotoService#buscarRegistro(java.lang.Long)
	 */
	@Override
	public Voto buscarRegistro(Long id) {
		// TODO Auto-generated method stub
		return this.repository.findOne(id);
	}

}

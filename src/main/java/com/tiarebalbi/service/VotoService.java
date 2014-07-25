package com.tiarebalbi.service;

import java.util.List;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import com.tiarebalbi.entity.Voto;

public interface VotoService {
	
	Voto salvar(Voto voto);
	
	List<Voto> buscarTodos(Predicate condicao, OrderSpecifier<?>... ordem);
	
	Voto buscarRegistro(Predicate condicao);
	
	Voto buscarRegistro(Long id);

}

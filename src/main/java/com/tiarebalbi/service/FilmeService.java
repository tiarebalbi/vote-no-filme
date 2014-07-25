package com.tiarebalbi.service;

import java.util.List;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import com.tiarebalbi.entity.Filme;

public interface FilmeService {
	
	Filme salvar(Filme filme);

	List<Filme> buscarTodos();
	
	List<Filme> buscarTodos(Predicate condicao);
	
	List<Filme> buscarTodos(Predicate condicao, OrderSpecifier<?>... ordem);
	
	Filme buscarRegistro(Long id);
	
	Filme buscarRegistro(Predicate condicao);
	
	void excluir(Long id);
	
	void excluir(Predicate condicao);
	
}

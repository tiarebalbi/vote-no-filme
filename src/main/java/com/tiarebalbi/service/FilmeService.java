package com.tiarebalbi.service;

import java.util.List;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import com.tiarebalbi.entity.Filme;

/**
 * @author Tiarê Balbi Bonamini
 */
public interface FilmeService {
	
	/**
	 * Salva um novo filme
	 * 
	 * @param filme
	 * @return {@link Filme}
	 */
	Filme salvar(Filme filme);

	/**
	 * Busca todos os filmes
	 * 
	 * @return {@link List}
	 */
	List<Filme> buscarTodos();
	
	/**
	 * Busca todos os filmes com condição
	 * 
	 * @param condicao {@link Predicate}
	 * @return {@link List}
	 */
	List<Filme> buscarTodos(Predicate condicao);
	
	/**
	 * Busca todos os usuário com condição e ordenação
	 * 
	 * @param condicao {@link Predicate}
	 * @param ordem {@link OrderSpecifier}
	 * @return {@link List}
	 */
	List<Filme> buscarTodos(Predicate condicao, OrderSpecifier<?>... ordem);
	
	/**
	 * Busca um filme pela chave primária
	 * 
	 * @param id {@link Long}
	 * @return {@link Filme}
	 */
	Filme buscarRegistro(Long id);
	
	/**
	 * 
	 * Busca um filme através de uma condição
	 * 
	 * @param condicao {@link Predicate}
	 * @return {@link Filme}
	 */
	Filme buscarRegistro(Predicate condicao);
	
	/**
	 * Exclui um registro através da chave primária
	 * 
	 * @param id {@link Long}
	 */
	void excluir(Long id);
	
	/**
	 * Exclui um filme através de uma condição
	 * 
	 * @param condicao {@link Predicate}
	 */
	void excluir(Predicate condicao);
	
}

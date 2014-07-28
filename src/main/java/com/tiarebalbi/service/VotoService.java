package com.tiarebalbi.service;

import java.util.List;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import com.tiarebalbi.entity.Voto;

/**
 * @author Tiarê Balbi Bonamini
 */
public interface VotoService {
	
	/**
	 * Salva um novo {@link Voto}
	 * 
	 * @param voto
	 * @return {@link Voto}
	 */
	Voto salvar(Voto voto);
	
	/**
	 * Busca todos os votos através de uma condição e uma ordenação
	 * 
	 * @param condicao {@link Predicate}
	 * @param ordem {@link OrderSpecifier}
	 * @return {@link List}
	 */
	List<Voto> buscarTodos(Predicate condicao, OrderSpecifier<?>... ordem);
	
	/**
	 * Busca um registro por uma condição
	 * 
	 * @param condicao {@link Predicate}
	 * @return {@link Voto}
	 */
	Voto buscarRegistro(Predicate condicao);
	
	/**
	 * Busca um registro através da chave primária
	 * 
	 * @param id {@link Long}
	 * @return {@link Voto}
	 */
	Voto buscarRegistro(Long id);

}

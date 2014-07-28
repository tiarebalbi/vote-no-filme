package com.tiarebalbi.service;

import java.util.List;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import com.tiarebalbi.entity.Usuario;

/**
 * @author Tiarê Balbi Bonamini
 */
public interface UsuarioService {
	
	/**
	 * Salva um novo usuário no sistema
	 * 
	 * @param usuario
	 * @return {@link Usuario}
	 */
	Usuario salvar(Usuario usuario);
	
	/**
	 * Busca todos os usuário de acordo com a condição e a ordenação informada
	 * 
	 * @param condicao {@link Predicate}
	 * @param ordem {@link OrderSpecifier}
	 * @return {@link List}
	 */
	List<Usuario> buscarTodos(Predicate condicao, OrderSpecifier<?>... ordem);

}

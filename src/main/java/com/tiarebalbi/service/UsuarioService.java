package com.tiarebalbi.service;

import java.util.List;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import com.tiarebalbi.entity.Usuario;

public interface UsuarioService {
	
	Usuario salvar(Usuario usuario);
	
	List<Usuario> buscarTodos(Predicate condicao, OrderSpecifier<?>... ordem);

}

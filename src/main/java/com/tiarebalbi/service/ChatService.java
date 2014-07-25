package com.tiarebalbi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mysema.query.types.Predicate;
import com.tiarebalbi.entity.Chat;

public interface ChatService {
	
	Chat salvar(Chat mensagem);
	
	Page<Chat> buscarTodos(Predicate condicao, Pageable paginacao);

}

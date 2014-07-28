package com.tiarebalbi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mysema.query.types.Predicate;
import com.tiarebalbi.entity.Chat;

/**
 * @author Tiarê Balbi Bonamini
 */
public interface ChatService {
	
	/**
	 * Salva uma nova mensagem enviada
	 * 
	 * @param mensagem
	 * @return {@link Chat}
	 */
	Chat salvar(Chat mensagem);
	
	/**
	 * Busca as últimas mensagens enviadas de acordo com  a condicao {@link Predicate} e a configuração da página {@link Pageable}
	 * 
	 * @param condicao
	 * @param paginacao
	 * @return {@link Page}
	 */
	Page<Chat> buscarTodos(Predicate condicao, Pageable paginacao);

}

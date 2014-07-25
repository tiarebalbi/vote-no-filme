package com.tiarebalbi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.mysema.query.types.Predicate;
import com.tiarebalbi.entity.Chat;

@Service
@Transactional
public class CustomChatService implements ChatService {

	@Override
	public Chat salvar(Chat mensagem) {
		
		Assert.notNull(mensagem,"Não foi possível identificar os dados da mensagem");
		Assert.notNull(mensagem.getUsuario(), "O usuário da mensagem deve ser informado");
		
		return null;
	}

	@Override
	public Page<Chat> buscarTodos(Predicate condicao, Pageable paginacao) {
		return null;
	}

}

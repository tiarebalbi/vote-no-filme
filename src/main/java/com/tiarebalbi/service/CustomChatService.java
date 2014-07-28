package com.tiarebalbi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.mysema.query.types.Predicate;
import com.tiarebalbi.entity.Chat;
import com.tiarebalbi.repository.ChatRepository;

/**
 * Service de acesso ao repository {@link ChatRepository}
 * 
 * @author Tiarê Balbi Bonamini
 */
@Service
@Transactional
public class CustomChatService implements ChatService {
	
	private final ChatRepository repository;
	
	/**
	 * @param repository {@link ChatRepository}
	 */
	@Autowired
	public CustomChatService(ChatRepository repository) {
		this.repository = repository;
	}

	@Override
	public Chat salvar(Chat mensagem) {
		
		Assert.notNull(mensagem,"Não foi possível identificar os dados da mensagem");
		Assert.notNull(mensagem.getUsuario(), "O usuário da mensagem deve ser informado");
		
		return this.repository.save(mensagem);
	}

	@Override
	public Page<Chat> buscarTodos(Predicate condicao, Pageable paginacao) {
		Assert.notNull(condicao,"Não foi possível identificar a condição de busca dos dados.");
		Assert.notNull(paginacao,"Não foi possível identificar os parâmetros de páginação");
		
		return this.repository.findAll(condicao, paginacao);
	}

}

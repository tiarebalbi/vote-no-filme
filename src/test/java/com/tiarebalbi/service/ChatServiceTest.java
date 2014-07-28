package com.tiarebalbi.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.mysema.query.types.Predicate;
import com.tiarebalbi.entity.Chat;
import com.tiarebalbi.entity.QChat;
import com.tiarebalbi.entity.Usuario;
import com.tiarebalbi.repository.ChatRepository;

/**
 *
 * @author Tiare Balbi Bonamini
 * @version 1.0.0.RELEASE 
 *
 * Jul 28, 2014
 *
 */
@RunWith(value=MockitoJUnitRunner.class)
public class ChatServiceTest {
	
	@Mock
	private ChatRepository repository;
	
	private CustomChatService service;
	
	/**
	 * 
	 */
	@Before
	public void init() {
		this.service = new CustomChatService(repository);
	}
	
	/**
	 * 
	 */
	@Test
	public void deveSalvarUmNovoChat() {
		Chat mensagem = new Chat();
		mensagem.setUsuario(new Usuario("Tiare", "tiarebalbi@me.com"));
		
		when(this.repository.save(mensagem)).thenReturn(mensagem);
		
		Chat retorno = this.service.salvar(mensagem);
		assertNotNull("O retorno não deve ser null",retorno);
		
		verify(this.repository, times(1)).save(mensagem);
		verifyNoMoreInteractions(this.repository);
	}
	
	/**
	 * 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void deveSalvarUmChatNull() {
		this.service.salvar(null);
		fail("Deve gerar erro pois não é possível salvar um objeto null");
	}
	
	/**
	 * 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void deveSalvarChatSemUsuario() { 
		Chat mensagem = new Chat();
		this.service.salvar(mensagem);
		fail("Deve gerar erro pois não foi informado o usuário");
	}
	
	/**
	 * 
	 */
	@Test
	public void deveBuscarTodosOsRegistrosComCondicaoEOrdenacao() {
		
		Page<Chat> dados = new PageImpl<Chat>(new ArrayList<Chat>());
		
		Predicate condicao = QChat.chat.usuario.isNotNull();
		PageRequest paginacao = new PageRequest(0, 1);
		when(this.repository.findAll(condicao, paginacao)).thenReturn(dados);
		
		Page<Chat> retorno = this.service.buscarTodos(condicao, paginacao);
		assertNotNull("O retorno não deve ser null",retorno);
		
		verify(this.repository, times(1)).findAll(condicao, paginacao);
		verifyNoMoreInteractions(this.repository);
	}
	
}

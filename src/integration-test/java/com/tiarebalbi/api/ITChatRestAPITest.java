package com.tiarebalbi.api;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.tiarebalbi.config.ApplicationContext;
import com.tiarebalbi.entity.Chat;
import com.tiarebalbi.entity.Usuario;
import com.tiarebalbi.repository.ChatRepository;
import com.tiarebalbi.repository.UsuarioRepository;
import com.tiarebalbi.service.ChatService;
import com.tiarebalbi.service.UsuarioService;

/**
 * @author Tiarê Balbi Bonamini
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationContext.class)
@WebAppConfiguration
public class ITChatRestAPITest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private ChatRepository repository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	/**
	 * 
	 */
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void deveListarUltimasMensagens() throws Exception {
		
		Usuario usuario = new Usuario("Tiarê Balbi", "tiarebalbi@me.com");
		usuario = this.usuarioService.salvar(usuario);
		
		Chat mensagem = new Chat();
		mensagem.setMensagem("DAwdqwd");
		mensagem.setUsuario(usuario);
		
		mensagem = this.chatService.salvar(mensagem);
		
		
		this.mockMvc.perform(get("/api/chat/listar").accept(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.data", hasSize(1)))
			.andExpect(jsonPath("$.data[0].mensagem", is("DAwdqwd")))
			.andExpect(jsonPath("$.data[0].usuario.nome", is("Tiarê Balbi")));
	}
	
	/**
	 * 
	 */
	@After
	public void limpeza() {
		
		List<Chat> dados = this.repository.findAll();
		for(Chat chat : dados) {
			this.repository.delete(chat);
		}
		
		List<Usuario> usuarios = this.usuarioRepository.findAll();
		this.usuarioRepository.delete(usuarios);
	}

}

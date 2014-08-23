package com.tiarebalbi.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
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
import com.tiarebalbi.entity.Usuario;
import com.tiarebalbi.repository.UsuarioRepository;

/**
 * @author Tiarê Balbi Bonamini
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationContext.class)
@WebAppConfiguration
public class ITUsuarioRestAPITest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
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
	public void deveSalvarUmNovoUsuario() throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(new Usuario("Tiarê Balbi", "tiarebalbi@me.com"));
		
		this.mockMvc.perform(post("/api/usuario")
							.accept(MediaType.APPLICATION_JSON_VALUE)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON)
					)
					.andExpect(jsonPath("$.message", is("Usuário Registrado com Sucesso!!!")))
					.andExpect(jsonPath("$.status", is("success")))
					.andExpect(status().isOk());
	}
	
	/**
	 * 
	 */
	@After
	public void limpeza() {
		
		List<Usuario> usuarios = this.usuarioRepository.findAll();
		this.usuarioRepository.delete(usuarios);
	}

}

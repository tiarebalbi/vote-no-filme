package com.tiarebalbi.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.tiarebalbi.entity.Filme;
import com.tiarebalbi.entity.Voto;
import com.tiarebalbi.repository.VotoRepository;
import com.tiarebalbi.service.FilmeService;

/**
 * @author Tiarê Balbi Bonamini
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationContext.class)
@WebAppConfiguration
public class ITVotoRestAPITest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Autowired
	private FilmeService service;
	
	@Autowired
	private VotoRepository repository;
	
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
	public void deveSalvarUmNovoVoto() throws Exception {
		
		Filme filme = new Filme();
		filme.setNome("Filme 1");
		filme = this.service.salvar(filme);
		
		String json = "{\"filme\" : { \"id\" : "+filme.getId()+"}}";

		this.mockMvc.perform(post("/api/voto")
							.accept(MediaType.APPLICATION_JSON_VALUE)
							.content(json)
							.contentType(MediaType.APPLICATION_JSON)
					)
					.andExpect(jsonPath("$.message", is("Voto Registrado com Sucesso!!!")))
					.andExpect(jsonPath("$.status", is("success")))
					.andExpect(status().isOk());
		
	}

    @Test
    public void deveBuscarTotalDeVotos() throws Exception {

        this.mockMvc.perform(get("/api/voto/total")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(jsonPath("$.total", is(0)))
                        .andExpect(status().isOk());
    }
	
	/**
	 * 
	 */
	@After
	public void limpeza() {
		
		List<Voto> dados = this.repository.findAll();
		this.repository.delete(dados);
		
		List<Filme> filmes = this.service.buscarTodos();
		for (Filme filme : filmes) {
			this.service.excluir(filme.getId());
		}
	}

}

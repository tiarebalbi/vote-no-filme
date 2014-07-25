package com.tiarebalbi.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tiarebalbi.config.ApplicationContext;
import com.tiarebalbi.entity.Filme;

/**
 * @author Tiarê Balbi Bonamini
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationContext.class)
@WebAppConfiguration
public class ITFilmeRepositoryTest {
	
	@Autowired
	private FilmeRepository repository;
	
	/**
	 * Deve testar salvar um novo filme na base de dados
	 */
	@Test
	public void deveTestarSalvarUmNovoFilme() {
		
		Filme filme = new Filme("Need for Speed");
		Filme retorno = this.repository.save(filme);
		assertNotNull("O Filme deve ser persistido na base de dados", retorno);
		assertNotNull("A ID do registro não deve ser null", retorno.getId());
		assertEquals(filme.getNome(), retorno.getNome());
		
	}

}

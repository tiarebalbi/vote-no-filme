package com.tiarebalbi.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tiarebalbi.config.ApplicationContext;
import com.tiarebalbi.entity.Filme;
import com.tiarebalbi.entity.QFilme;

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
		
		Filme filme = new Filme();
		filme.setNome("Need for Speed");
		Filme retorno = this.repository.save(filme);
		assertNotNull("O Filme deve ser persistido na base de dados", retorno);
		assertNotNull("A ID do registro não deve ser null", retorno.getId());
		assertEquals("O nome do filme deve ser igual ao valor retornado pelo repository",filme.getNome(), retorno.getNome());
		
	}
	
	/**
	 * Busca registros salvo no banco
	 */
	@Test
	public void deveTestarRealizadaConsultaDeRegistros() {
		Filme filme = new Filme();
		filme.setNome("Need for Speed 1");

		Filme filme2 = new Filme();
		filme2.setNome("Need for Speed 2");

		Filme filme3 = new Filme();
		filme3.setNome("Need for Speed 3");

		Filme filme4 = new Filme();
		filme4.setNome("Need for Speed 4");

		Filme retorno = this.repository.save(filme);
		this.repository.save(filme2);
		this.repository.save(filme3);
		this.repository.save(filme4);
		
		List<Filme> registros = this.repository.findAll();
		assertNotNull("O Filme deve ser persistido na base de dados", registros);
		assertEquals("O nome do primeiro filme deve ser Need for Speed 1", filme.getNome(), retorno.getNome());
		assertTrue("O total de registro deve ser igual a 4", registros.size() == 4);
	}
	
	/**
	 * 
	 */
	@Test
	public void deveBuscarUmRegistro() {
		Filme filme = new Filme();
		filme.setNome("Need for Speed 4");
		
		Filme retorno = this.repository.save(filme);
		
		Filme retornoConsulta = this.repository.findOne(retorno.getId());
		assertNotNull("O retorno da consulta não deve ser null", retornoConsulta);
		assertEquals("O nome do filme deve ser igual ao valor persistido", filme.getNome(), retornoConsulta.getNome());
	}
	
	/**
	 * 
	 */
	@Test
	public void deveBuscarUmRegistroPorCondicao() {
		Filme filme = new Filme();
		filme.setNome("Need for Speed 4");
		this.repository.save(filme);
		
		Filme retorno = this.repository.findOne(QFilme.filme.nome.eq("Need for Speed 4"));
		
		assertNotNull("O retorno da consulta não deve ser null", retorno);
		
	}
	
	/**
	 * 
	 */
	@Test
	public void deveExcluirUmRegistroPorId() {
		Filme filme = new Filme();
		filme.setNome("Need for Speed 4");
		Filme retorno = this.repository.save(filme);
		
		assertTrue("O total de registro deve ser igual a 1", this.repository.count() == 1);
		
		this.repository.delete(retorno.getId());
		
		assertTrue("O total de registro deve ser igual a 0", this.repository.count() == 0);
		
	}
	
	/**
	 * Limpa registro após sua execução
	 */
	@After
	public void deveLimparTodosRegistros() {
		List<Filme> dados = this.repository.findAll();
		for (Filme filme : dados) {
			this.repository.delete(filme);
		}
	}

}

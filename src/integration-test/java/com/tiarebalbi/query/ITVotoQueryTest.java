package com.tiarebalbi.query;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tiarebalbi.config.ApplicationContext;
import com.tiarebalbi.domain.dto.RankFilmeDTO;
import com.tiarebalbi.entity.Filme;
import com.tiarebalbi.entity.Usuario;
import com.tiarebalbi.entity.Voto;
import com.tiarebalbi.repository.FilmeRepository;
import com.tiarebalbi.repository.UsuarioRepository;
import com.tiarebalbi.repository.VotoRepository;

/**
 * @author Tiarê Balbi Bonamini
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationContext.class)
@WebAppConfiguration
public class ITVotoQueryTest {
	
	@Autowired
	private VotoQuery query;
	
	@Autowired
	private FilmeRepository repositoryFilme;
	
	@Autowired
	private UsuarioRepository repositoryUsuario;
	
	@Autowired
	private VotoRepository repository;
	
	/**
	 * Cadastro dos votos padrões
	 */
	@Before
	public void init() {
		
		Filme filme1 = new Filme();
		filme1.setNome("Filme 1");
		Filme filme2 = new Filme();
		filme2.setNome("Filme 2");
		Filme filme3 = new Filme();
		filme3.setNome("Filme 3");
		
		filme1 = this.repositoryFilme.save(filme1);
		filme2 = this.repositoryFilme.save(filme2);
		filme3 = this.repositoryFilme.save(filme3);
		
		Voto voto1 = new Voto();
		voto1.setSession("S1");
		voto1.setFilme(filme1);
		this.repository.save(voto1);
		
		Voto voto2 = new Voto();
		voto2.setSession("S1");
		voto2.setFilme(filme1);
		this.repository.save(voto2);
		
		Voto voto3 = new Voto();
		voto3.setSession("S2");
		voto3.setFilme(filme2);
		this.repository.save(voto3);
		
		Voto voto4 = new Voto();
		voto4.setSession("S1");
		voto4.setFilme(filme3);
		this.repository.save(voto4);
		
	}
	
	/**
	 * 
	 */
	@After
	public void limparRegistros() {
		
		// Limpar Votos
		List<Voto> registros2 = this.repository.findAll();
		for (Voto voto : registros2) {
			this.repository.delete(voto.getId());
		}
		
		// Limpar Filmes
		List<Filme> registros = this.repositoryFilme.findAll();
		for (Filme filme : registros) {
			this.repositoryFilme.delete(filme.getId());
		}
		
	}
	
	/**
	 * 
	 */
	@Test
	public void deveConsultarRankGerarl() {
		List<RankFilmeDTO> registros = this.query.buscarRankGeral();
		assertNotNull("O retorno da consulta não deve ser vazia", registros);
		assertEquals("O primeiro filme deve ser o 'Filme 1'", "Filme 1", registros.get(0).getFilme());
	}
	
	/**
	 * 
	 */
	@Test
	public void deveConsultarRankPorUsuario() {
		
		Usuario usuario = new Usuario("Tiarê Balbi", "tiarebalbi@me.com");
		usuario.addSessao("S1");
		this.repositoryUsuario.save(usuario);
		
		List<RankFilmeDTO> retorno = this.query.buscarRankPorUsuario(usuario);
		assertNotNull("O retorno da consulta não deve ser nullo", retorno);
		assertTrue("O total de registro deve ser igual a 2", 2 == retorno.size());
		assertEquals("O primeiro filme deve ser o 'Filme 1'", "Filme 1", retorno.get(0).getFilme());
		assertEquals("O segundo filme deve ser o 'Filme 3'", "Filme 3", retorno.get(1).getFilme());
		
		
		
		this.repositoryUsuario.delete(usuario);
		
	}

}

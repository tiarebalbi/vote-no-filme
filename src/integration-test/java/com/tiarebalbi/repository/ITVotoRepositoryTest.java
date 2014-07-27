package com.tiarebalbi.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tiarebalbi.config.ApplicationContext;
import com.tiarebalbi.entity.QVoto;
import com.tiarebalbi.entity.Voto;

/**
 * @author Tiarê Balbi Bonamini
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationContext.class)
@WebAppConfiguration
public class ITVotoRepositoryTest {
	
	@Autowired
	private VotoRepository repository;
	
	
	/**
	 * 
	 */
	@Test
	public void deveSalvarUmRegistro() {
		
		Voto voto = new Voto();
		voto.setSession("S1");
		Voto retorno = this.repository.save(voto);
		
		assertNotNull("O retorno não deve ser nullo", retorno);
		assertNotNull("O registro após ser salvo deve possuir a sua ID", retorno.getId());
		
	}
	
	/**
	 * 
	 */
	@Test
	public void deveBuscarTodosRegistros() {
		
		Voto voto = new Voto();
		voto.setSession("S1");
		this.repository.save(voto);
		
		Voto voto2 = new Voto();
		voto2.setSession("S2");
		this.repository.save(voto2);
		
		List<Voto> retorno = this.repository.findAll();
		assertNotNull("O retorno não deve ser nullo", retorno);
		assertTrue("O total de registro deve ser igual a 2", 2 == retorno.size());
		
	}
	
	/**
	 * 
	 */
	@Test
	public void deveBuscarUmRegistroPorId() {
		
		Voto voto = new Voto();
		voto.setSession("S1");
		Voto retorno = this.repository.save(voto);
		
		Voto findOne = this.repository.findOne(retorno.getId());
		
		assertNotNull("O retorno não deve ser nullo", findOne);
		assertEquals("A sessão deve ser igual a cadastrada", "S1", findOne.getSession());
		
	}
	
	/**
	 * 
	 */
	@Test
	public void deveBuscarUmRegistroPorCondicao() {
		
		Voto voto = new Voto();
		voto.setSession("S2");
		this.repository.save(voto);
		
		Voto findOne = this.repository.findOne(QVoto.voto.session.eq("S2"));
		
		assertNotNull("O retorno não deve ser nullo", findOne);
		assertEquals("A sessão deve ser igual a cadastrada", "S2", findOne.getSession());
		
	}
	
	/**
	 * 
	 */
	@Test
	public void deveExcluirUmRegistroPorId() {
		
		Voto voto = new Voto();
		voto.setSession("S2");
		Voto retorno = this.repository.save(voto);
		
		this.repository.delete(retorno.getId());
		
		assertTrue("Não deve existir nenhum registro na base de dados", this.repository.count()  == 0);
		
	}
	
	
	/**
	 * Limpa registro após sua execução
	 */
	@After
	public void deveLimparTodosRegistros() {
		List<Voto> dados = this.repository.findAll();
		for (Voto Voto : dados) {
			this.repository.delete(Voto);
		}
	}

}

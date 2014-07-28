package com.tiarebalbi.service;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mysema.query.types.Predicate;
import com.tiarebalbi.entity.Filme;
import com.tiarebalbi.entity.QFilme;
import com.tiarebalbi.repository.FilmeRepository;

/**
 * @author Tiarê Balbi Bonamini
 *
 */
@RunWith(value=MockitoJUnitRunner.class)
public class FilmeServiceTest {
	
	@Mock
	private FilmeRepository repository;
	
	private CustomFilmeService service;
	
	/**
	 * 
	 */
	@Before
	public void init() {
		this.service = new CustomFilmeService(repository);
	}

	
	/**
	 * 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void deveSalvarUmUsuarioInvalidoEGerarErro() {
		this.service.salvar(null);
		fail("Deveria ter gerado uma IllegalArgumentException devido ao objeto ser nullo");
	}
	
	/**
	 * 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void deveSalvarUmFilmeExistenteEGerarErro() {
		when(this.repository.count(any(Predicate.class))).thenReturn(new Long(2));
		this.service.salvar(new Filme("Teste"));
		fail("Deveria ter gerado uma IllegalArgumentException pois este filme já se encontra cadastrado");
	}
	
	/**
	 * 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void deveBuscarTodosComCondicaoNullaEGerarErro() {
		this.service.buscarTodos(null);
		fail("Deveria ter gerado uma IllegalArgumentException devido ao objeto ser nullo");
	}
	
	/**
	 * 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void deveExcluirRegistroPorIdInvalida() {
		this.service.buscarRegistro(new Long(0));
		fail("Deveria ter gerado uma IllegalArgumentException a ID informada ser invalida");
	}
	
	/**
	 * 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void deveExcluirRegistroNaoCadastradoEGerarErro() {
		when(this.repository.findOne(any(Predicate.class))).thenReturn(null);
		this.service.excluir(QFilme.filme.nome.eq("Tiarê"));
		fail("Deveria ser gerado um erro pois tentou excluir um registro que não existe.");
	}
	
}

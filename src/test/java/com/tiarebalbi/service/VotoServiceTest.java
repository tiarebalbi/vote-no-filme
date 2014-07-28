package com.tiarebalbi.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import com.tiarebalbi.entity.Filme;
import com.tiarebalbi.entity.QVoto;
import com.tiarebalbi.entity.Voto;
import com.tiarebalbi.repository.VotoRepository;

/**
 *
 * @author Tiare Balbi Bonamini
 * @version 1.0.0.RELEASE 
 *
 * Jul 28, 2014
 *
 */
@RunWith(value=MockitoJUnitRunner.class)
public class VotoServiceTest {
	
	@Mock
	private VotoRepository repository;
	
	private CustomVotoService service;
	
	/**
	 * 
	 */
	@Before
	public void init() {
		this.service = new CustomVotoService(repository);
	}
	
	/**
	 * 
	 */
	@Test
	public void deveSalvarUmNovoVoto() {
		Voto voto = new Voto();
		voto.setFilme(new Filme("Filme 1"));
		voto.setSession("S1");
		
		when(this.repository.save(voto)).thenReturn(voto);
		
		Voto retorno = this.service.salvar(voto);
		assertNotNull("O retorno não deve ser null",retorno);
		
		verify(this.repository, times(1)).save(voto);
		verifyNoMoreInteractions(this.repository);
	}
	
	/**
	 * 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void deveSalvarUmVotoNull() {
		this.service.salvar(null);
		fail("Deve gerar erro pois não é possível salvar um objeto null");
	}
	
	/**
	 * 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void deveSalvarVotoSemFilme() { 
		Voto voto = new Voto();
		voto.setSession("S1");
		
		this.service.salvar(voto);
		fail("Deve gerar erro pois não foi informado o filme");
	}
	
	/**
	 * 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void deveSalvarVotoSemSessao() { 
		Voto voto = new Voto();
		voto.setFilme(new Filme("Filme 1"));
		this.service.salvar(voto);
		fail("Deve gerar erro pois não foi informado a sessão do usuário");
	}
	
	/**
	 * 
	 */
	@Test
	public void deveBuscarTodosOsRegistrosComCondicaoEOrdenacao() {
		
		Iterable<Voto> dados = new ArrayList<>();
		Predicate condicao = QVoto.voto.session.eq("S1");
		OrderSpecifier<?> ordem = QVoto.voto.session.asc();
		when(this.repository.findAll(condicao, ordem)).thenReturn(dados);
		
		List<Voto> retorno = this.service.buscarTodos(condicao, ordem);
		assertNotNull("O retorno não deve ser null",retorno);
		
		verify(this.repository, times(1)).findAll(condicao, ordem);
		verifyNoMoreInteractions(this.repository);
	}
	
	/**
	 * 
	 */
	@Test
	public void deveBuscarRegistroComCondicao() {
		
		Voto voto = new Voto();
		Predicate condicao = QVoto.voto.session.eq("S1");
		when(this.repository.findOne(condicao)).thenReturn(voto);
		
		Voto retorno = this.service.buscarRegistro(condicao);
		assertNotNull("O retorno não deve ser null",retorno);
		
		verify(this.repository, times(1)).findOne(condicao);
		verifyNoMoreInteractions(this.repository);
	}
	
	/**
	 * 
	 */
	@Test
	public void deveBuscarRegistroPorId() {
		
		Voto voto = new Voto();
		voto.setId(new Long(1));
		
		when(this.repository.findOne(new Long(1))).thenReturn(voto);
		
		Voto retorno = this.service.buscarRegistro(voto.getId());
		assertNotNull("O retorno não deve ser null",retorno);
		
		verify(this.repository, times(1)).findOne(voto.getId());
		verifyNoMoreInteractions(this.repository);
	}
	
}

package com.tiarebalbi.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mysema.query.types.Predicate;
import com.tiarebalbi.entity.Usuario;
import com.tiarebalbi.repository.UsuarioRepository;

/**
 *
 * @author Tiare Balbi Bonamini
 * Jul 28, 2014
 *
 */
@RunWith(value=MockitoJUnitRunner.class)
public class UsuarioServiceTest {
	
	@Mock
	private UsuarioRepository repository;
	
	private UsuarioService service;
	
	/**
	 * 
	 */
	@Before
	public void init () {
		this.service = new CustomUsuarioService(repository);
	}
	
	
	/**
	 * 
	 */
	@Test
	public void deveSalvarUmNovoUsuario() {
		Usuario usuario = new Usuario("Tiarê Balbi", "tiarebalbi@me.com");
		
		when(this.repository.save(usuario)).thenReturn(usuario);
		Usuario retorno = this.service.salvar(usuario);
		
		assertNotNull("O retorno não deve ser null", retorno);
		
		verify(this.repository, times(1)).count(any(Predicate.class));
		verify(this.repository, times(1)).save(usuario);
		verifyNoMoreInteractions(this.repository);
	}
	
	/**
	 * 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void deveSalvarUmNovoUsuarioComEmailExistenteEGerarErro() {
		Usuario usuario = new Usuario("Tiarê Balbi", "tiarebalbi@me.com");
		when(this.repository.count(any(Predicate.class))).thenReturn(new Long(1));
		this.service.salvar(usuario);
		fail("Deve gerar uma falha ao tentar salvar um email existente");
	}
	
	/**
	 * 
	 */
	@Test
	public void deveAlterarUmUsuarioENaoGerarErro() {
		Usuario usuario = new Usuario("Tiarê Balbi", "tiarebalbi@me.com");
		usuario.setId(new Long(1));
		when(this.repository.count(any(Predicate.class))).thenReturn(new Long(0));
		when(this.repository.save(usuario)).thenReturn(usuario);
		
		Usuario retorno = this.service.salvar(usuario);

		assertNotNull("O retorno não deve ser null", retorno);
		
		verify(this.repository, times(1)).count(any(Predicate.class));
		verify(this.repository, times(1)).save(usuario);
		
		verifyNoMoreInteractions(this.repository);
		
	}

}

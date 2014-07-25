package com.tiarebalbi.entity;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Teste de métodos da entidade {@link Usuario}
 * 
 * @author Tiarê Balbi Bonamini
 *
 */
public class UsuarioTest {

	
	/**
	 * 
	 */
	@Test
	public void deveTestarInserirUmaSessaoNoRegistroDoUsuario() {
		
		Usuario usuario = new Usuario("Tiarê Balbi", "tiarebalbi@me.com");
		usuario.addSessao("XXX");
		usuario.addSessao("YYY");
		
		assertNotNull("O registro de sessão não pode ser null", usuario.getSessoes());
		assertTrue("O total de sessões deve ser igual a 2", 2 == usuario.getSessoes().size());
		
		
	}
	
}

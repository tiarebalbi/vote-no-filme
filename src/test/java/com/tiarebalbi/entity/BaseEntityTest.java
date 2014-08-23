package com.tiarebalbi.entity;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Tiarê Balbi Bonamini
 */
public class BaseEntityTest {

	private static final int PRIMEIRO = 1;
	private static final int SEGUNDO = 2;

	/**
	 * 
	 */
	@Test
	public void deveTestarMetodoEquals() {
		
		Filme filme = new Filme();
		filme.setNome("Nome");
		filme.setId(new Long(PRIMEIRO));
		
		Filme filme2 = new Filme();
		filme2.setNome("No3me");
		
		filme2.setId(new Long(PRIMEIRO));
		
		assertTrue("Os objetos devem ser iguais, pois utilizam a mesma ID", filme.equals(filme2));
		
	}
	
	/**
	 * 
	 */
	@Test
	public void deveTestarMetodoEqualsComValoresDiferentes() {
		Filme filme = new Filme();
		filme.setNome("Nome");
		filme.setId(new Long(PRIMEIRO));
		
		Filme filme2 = new Filme();
		filme2.setNome("No3me");
		filme2.setId(new Long(SEGUNDO));
		
		assertFalse("Os objetos devem ser diferente, pois utilizam ID's diferentes", filme.equals(filme2));
	}
	
	/**
	 * 
	 */
	@Test
	public void deveTestarMetodoComObjetoSemIdENaoGerarErro() {
		
		Filme filme = new Filme();
		filme.setNome("Nome");
		filme.setId(new Long(PRIMEIRO));
		
		Filme filme2 = new Filme();
		filme2.setNome("No3me");
		
		assertFalse("Os objetos devem ser diferente, a segunda instancia não possui ID", filme.equals(filme2));
		
	}
	
}

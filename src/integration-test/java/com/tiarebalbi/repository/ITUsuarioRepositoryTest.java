package com.tiarebalbi.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
import com.tiarebalbi.entity.QUsuario;
import com.tiarebalbi.entity.Usuario;

/**
 * @author Tiarê Balbi Bonamini
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationContext.class)
@WebAppConfiguration
public class ITUsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository repository;
	
	private Usuario usuario;
	
	/**
	 * 
	 */
	@Before
	public void init() {
		
		Usuario usuario = new Usuario("Tiarê Balbi", "tiarebalbi@me.com");
		this.usuario = this.repository.save(usuario);
	}
	
	/**
	 * 
	 */
	@Test
	public void deveBuscarUmRegistroPorCondicao() {
		
		Usuario findOne = this.repository.findOne(QUsuario.usuario.nome.eq("Tiarê Balbi"));
		
		assertNotNull("O retorno não pode ser vazio", findOne);
		assertEquals("A sessão deve ser igual a cadastrada", "Tiarê Balbi", findOne.getNome());
		
	}
	
	
	/**
	 * 
	 */
	@Test
	public void deveSalvarUmRegistro() {
		
		Usuario usuario = new Usuario("Tiarê Balbi 2", "me@tiarebalbi.com");
		Usuario retorno = this.repository.save(usuario);
		
		assertNotNull("O retorno não deve ser nullo", retorno);
		assertNotNull("O registro após ser salvo deve possuir a sua ID", retorno.getId());
		
	}
	
	/**
	 * 
	 */
	@Test
	public void deveBuscarTodosRegistros() {
		
		Usuario usuario = new Usuario("Tiarê Balbi 3", "tiare@outlook.com.br");
		this.repository.save(usuario);
		
		Usuario usuario2 = new Usuario("Teste", "teste@teste.com");
		this.repository.save(usuario2);
		
		List<Usuario> retorno = this.repository.findAll();
		assertNotNull("O retorno não deve ser nullo", retorno);
		assertTrue("O total de registro deve ser igual a 3", 3 == retorno.size());
		
	}
	
	/**
	 * 
	 */
	@Test
	public void deveBuscarUmRegistroPorId() {
		
		Usuario retorno = this.repository.save(this.usuario);
		Usuario findOne = this.repository.findOne(retorno.getId());
		
		assertNotNull("O retorno não deve ser nullo", findOne);
		assertEquals("A sessão deve ser igual a cadastrada", "tiarebalbi@me.com", findOne.getEmail());
		
	}
	
	/**
	 * 
	 */
	@Test
	public void deveExcluirUmRegistroPorId() {
		
		this.repository.delete(this.usuario.getId());
		
		assertTrue("Não deve existir nenhum registro na base de dados", this.repository.count()  == 0);
		
	}
	
	
	/**
	 * Limpa registro após sua execução
	 */
	@After
	public void deveLimparTodosRegistros() {
		List<Usuario> dados = this.repository.findAll();
		for (Usuario Usuario : dados) {
			this.repository.delete(Usuario);
		}
	}

}

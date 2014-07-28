/**
 * 
 */
package com.tiarebalbi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import com.tiarebalbi.entity.QUsuario;
import com.tiarebalbi.entity.Usuario;
import com.tiarebalbi.repository.UsuarioRepository;

/**
 * @author Tiarê Balbi Bonamini
 */
@Service
@Transactional
public class CustomUsuarioService implements UsuarioService {
	
	private final UsuarioRepository repository;
	
	/**
	 * @param repository {@link UsuarioRepository}
	 */
	@Autowired
	public CustomUsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	/* (non-Javadoc)
	 * @see com.tiarebalbi.service.UsuarioService#salvar(com.tiarebalbi.entity.Usuario)
	 */
	@Override
	public Usuario salvar(Usuario usuario) {
		Assert.notNull(usuario, "Não foi possível identificar as informações do usuário");
		
		QUsuario entidade = QUsuario.usuario;
		long totalEmail = 0;
		
		if(usuario.getId() == null) {
			// Verifica se já existe o email
			totalEmail = this.repository.count(entidade.email.eq(usuario.getEmail()));
		}else {
			// Caso seja um update verifica se alguem que não seja ele tenha o mesmo e-mail
			totalEmail = this.repository.count(entidade.email.eq(usuario.getEmail()).and(entidade.id.ne(usuario.getId())));
		}
		
		Assert.isTrue(totalEmail == 0, "Não foi possível identificar as informações do usuário");
		
		return this.repository.save(usuario);
	}

	/* (non-Javadoc)
	 * @see com.tiarebalbi.service.UsuarioService#buscarTodos(com.mysema.query.types.Predicate, com.mysema.query.types.OrderSpecifier[])
	 */
	@Override
	public List<Usuario> buscarTodos(Predicate condicao, OrderSpecifier<?>... ordem) {
		Assert.notNull(condicao, "Não foi possível identificar a condição da busca");
		return (List<Usuario>) this.repository.findAll(condicao, ordem);
	}

}

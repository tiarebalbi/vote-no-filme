package com.tiarebalbi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.tiarebalbi.entity.Usuario;

/**
 * Repository da entidade {@link Usuario}
 * 
 * @author Tiarê Balbi Bonamini
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, QueryDslPredicateExecutor<Usuario> {

}

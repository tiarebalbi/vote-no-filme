package com.tiarebalbi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.tiarebalbi.entity.Filme;

/** 
 * Repository para a entidade {@link Filme}
 * 
 * @author Tiarê Balbi Bonamini
 * @see Filme
 */
@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long>, QueryDslPredicateExecutor<Filme> {
}

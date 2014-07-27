package com.tiarebalbi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.tiarebalbi.entity.Voto;

/**
 * Repository da entidade {@link Voto}
 * 
 * @author Tiarê Balbi Bonamini
 */
@Repository
public interface VotoRepository extends JpaRepository<Voto, Long>, QueryDslPredicateExecutor<Voto> {

}

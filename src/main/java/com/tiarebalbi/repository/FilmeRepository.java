package com.tiarebalbi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiarebalbi.entity.Filme;

/** 
 * Repository para a entidade {@link Filme}
 * 
 * @author Tiarê Balbi Bonamini
 * @see Filme
 */
@Repository
@Transactional
public interface FilmeRepository extends JpaRepository<Filme, Long> {
}

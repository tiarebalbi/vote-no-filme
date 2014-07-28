package com.tiarebalbi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.tiarebalbi.entity.Chat;

/**
 * Repository da entidade {@link Chat}
 * 
 * @author Tiarê Balbi Bonamini
 */
@Repository
public interface ChatRepository extends JpaRepository<Chat, Long>, QueryDslPredicateExecutor<Chat> {

}

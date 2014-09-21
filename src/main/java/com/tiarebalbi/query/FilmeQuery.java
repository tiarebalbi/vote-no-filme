package com.tiarebalbi.query;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.expr.NumberExpression;
import com.tiarebalbi.entity.Filme;
import com.tiarebalbi.entity.QFilme;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Tiarê Balbi Bonamini
 */
@Repository
public class FilmeQuery {

	@PersistenceContext
	private EntityManager em;

	/**
     * Método responsável por buscar dois filmes random
     *
	 * @return {@link java.util.List}
	 */
	public List<Filme> buscarFilmeRandom(int quantidade) {
		JPAQuery query = new JPAQuery(em);
		
		QFilme entidade = QFilme.filme;

        return query.from(entidade)
                .orderBy(NumberExpression.random().asc()).limit(quantidade).list(entidade);
	}

}
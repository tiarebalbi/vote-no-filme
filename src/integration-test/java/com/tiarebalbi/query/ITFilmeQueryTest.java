package com.tiarebalbi.query;

import com.tiarebalbi.config.ApplicationContext;
import com.tiarebalbi.entity.Filme;
import com.tiarebalbi.entity.Voto;
import com.tiarebalbi.repository.FilmeRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Tiarê Balbi Bonamini
 * @version Copyright Kupo.
 *          <p/>
 *          Created by Tiarê Balbi Bonamini on 9/19/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationContext.class)
@WebAppConfiguration
public class ITFilmeQueryTest {

    @Autowired
    private FilmeQuery query;

    @Autowired
    private FilmeRepository repositoryFilme;

    @Test
    public void deveBuscarDoisFilmesRandomicos() {

        Filme filme1 = new Filme();
        filme1.setNome("Filme 1");
        Filme filme2 = new Filme();
        filme2.setNome("Filme 2");
        Filme filme3 = new Filme();
        filme3.setNome("Filme 3");

        filme1 = this.repositoryFilme.save(filme1);
        filme2 = this.repositoryFilme.save(filme2);
        filme3 = this.repositoryFilme.save(filme3);

        List<Filme> filmes = this.query.buscarFilmeRandom(2);
        assertNotNull("O retorno da consulta não deve ser null", filmes);
        assertTrue(2 == filmes.size());
    }

    /**
     * Limpa registro após sua execução
     */
    @After
    public void deveLimparTodosRegistros() {
        List<Filme> dados = this.repositoryFilme.findAll();
        for (Filme filme : dados) {
            this.repositoryFilme.delete(filme);
        }
    }
}

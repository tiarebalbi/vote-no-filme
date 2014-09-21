package com.tiarebalbi.api;

import com.tiarebalbi.entity.Filme;
import com.tiarebalbi.query.FilmeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tiarê Balbi Bonamini
 */
@RestController
@RequestMapping(value="/api/filme/**", produces="application/json")
public class FilmeRestAPI {

    private static final int TOTAL_FILMES_POR_VOTO = 2;

    @Autowired
    private FilmeQuery query;

    @RequestMapping(method = RequestMethod.GET)
    public List<Filme> consultarFilmesParaVotacao () {
        List<Filme> filmes = this.query.buscarFilmeRandom(TOTAL_FILMES_POR_VOTO);
        return filmes;
    }

}

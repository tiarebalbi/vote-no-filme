package com.tiarebalbi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import com.tiarebalbi.entity.Filme;
import com.tiarebalbi.entity.QFilme;
import com.tiarebalbi.repository.FilmeRepository;

/**
 * @author Tiarê Balbi Bonamini
 */
@Service
@Transactional
public class CustomFilmeService implements FilmeService {
	
	
	private final FilmeRepository repository;
	
	/**
	 * Construtor padrão com a inicialização do repository {@link FilmeRepository}
	 * 
	 * @param repository
	 */
	@Autowired
	public CustomFilmeService(FilmeRepository repository) {
		this.repository = repository;
	}

	@Override
	public Filme salvar(Filme filme) {
		Assert.notNull(filme, "As informações referente ao filme devem ser preenchidas");
		
		long total = this.repository.count(QFilme.filme.nome.eq(filme.getNome()));
		Assert.isTrue(total == 0, "O filme informado já se encontra cadastrado.");

		return this.repository.save(filme);
	}

	@Override
	public List<Filme> buscarTodos() {
		return this.repository.findAll();
	}

	@Override
	public List<Filme> buscarTodos(Predicate condicao) {
		Assert.notNull(condicao, "A condição de busca deve ser informada.");
		
		return (List<Filme>) this.repository.findAll(condicao);
	}

	@Override
	public List<Filme> buscarTodos(Predicate condicao, OrderSpecifier<?>... ordem) {
		Assert.notNull(condicao, "A condição de busca deve ser informada.");
		Assert.notNull(ordem, "A condição de ordenação deve ser informada.");
		
		return (List<Filme>) this.repository.findAll(condicao, ordem);
	}

	@Override
	public Filme buscarRegistro(Long id) {
		Assert.notNull(id, "Não foi possível identificar o registro solicitado");
		Assert.isTrue(id != 0, "Identificação do registro é invalida");
		return this.repository.findOne(id);
	}

	@Override
	public Filme buscarRegistro(Predicate condicao) {
		Assert.notNull(condicao, "A condição de busca deve ser informada.");
		return this.repository.findOne(condicao);
	}

	@Override
	public void excluir(Long id) {
		Assert.notNull(id, "Não foi possível identificar o registro solicitado");
		this.repository.delete(id);
	}

	@Override
	public void excluir(Predicate condicao) {
		Assert.notNull(condicao, "Não foi possível identificar o registro solicitado");
		
		Filme registro = this.repository.findOne(condicao);
		Assert.notNull(registro, "Não foi possível localizar o registro informado.");
		
		this.repository.delete(registro.getId());
	}

}

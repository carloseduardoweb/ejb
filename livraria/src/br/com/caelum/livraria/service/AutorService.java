package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.exception.LivrariaException;
import br.com.caelum.livraria.model.Autor;

@Stateless
public class AutorService {

	@Inject
	private AutorDao dao;

	public void adiciona(Autor autor) {
		// more business logic here...
		
		dao.salva(autor);
		
		// A rule fails
		throw new LivrariaException("Uma regra falhou");
	}

	public List<Autor> todosAutores() {
		return dao.todosAutores();
	}

	public Autor buscaPorId(Integer autorId) {
		return dao.buscaPorId(autorId);
	}

}

package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.livraria.model.Autor;
import br.com.caelum.livraria.service.AutorService;

@Model
public class AutorBean {
	
	private Autor autor = new Autor();
	
	@Inject
	private AutorService autorService;
	
	public Autor getAutor() {
		return autor;
	}
	
	public void cadastra() {
		autorService.adiciona(autor);
		autor = new Autor();
	}
	
	public List<Autor> getAutores() {
		return autorService.todosAutores();
	}
}

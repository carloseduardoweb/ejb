package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.livraria.model.Autor;
import br.com.caelum.livraria.model.Livro;
import br.com.caelum.livraria.service.AutorService;
import br.com.caelum.livraria.service.LivroService;

@Model
public class LivroBean {
	
	private Livro livro = new Livro();
	private Integer autorId;
	
	@Inject
	private LivroService livroService;
	
	@Inject
	private AutorService autorService;

	public void cadastra() {
		livro.setAutor(autorService.buscaPorId(autorId));
		livroService.salva(livro);
		livro = new Livro();
	}

	public List<Autor> getAutores() {
		return autorService.todosAutores();
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
	public Integer getAutorId() {
		return autorId;
	}
	
	public List<Livro> getLivros() {
		return livroService.todosLivros();
	}
}

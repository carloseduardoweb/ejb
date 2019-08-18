package br.com.caelum.livraria.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.model.Autor;
import br.com.caelum.livraria.model.Livro;
import br.com.caelum.livraria.model.Usuario;

@Singleton // javax.ejb
//@Startup
public class BancoService {

	@PersistenceContext
	private EntityManager manager;

	@PostConstruct
	private void aposCriado() {
		System.out.println("Inicializando Banco");
		inicializaBanco();
		System.out.println("Banco inicializado");
	}

	private void inicializaBanco() {
		Autor autor1 = new Autor("Paulo Silveira");
		Autor autor2 = new Autor("Gilliard Cordeiro");
		Autor autor3 = new Autor("Hébert Coelho");

		List<Autor> autores = Arrays.asList(autor1, autor2, autor3);
		inicializaAutor(autores);
		inicializaLivro(autores);
		inicializaUsuario();
	}

	private void inicializaUsuario() {
		manager.persist(new Usuario("admin", "pass"));
	}

	private void inicializaLivro(List<Autor> autores) {
		manager.persist(new Livro("Java 8 prático", autores.get(0)));
		manager.persist(new Livro("Lógica de Programação", autores.get(0)));
		manager.persist(new Livro("CDI: Integre as dependências", autores.get(0)));
		manager.persist(new Livro("JSF e JPA", autores.get(1)));
		manager.persist(new Livro("JPA Eficaz", autores.get(2)));
	}

	private void inicializaAutor(List<Autor> autores) {
		for (Autor autor : autores) {
			manager.persist(autor);
		}
	}

}

package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.interceptor.LogLivros;
import br.com.caelum.livraria.model.Livro;

@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
//@Interceptors({LogInterceptor.class})
public class LivroDao {

	@PersistenceContext
	private EntityManager manager;
	
	public void salva(Livro livro) {
		System.out.println("Salvando o livro '" + livro.getTitulo() + "'");
		manager.persist(livro);
		System.out.println("Livro '" + livro.getTitulo() + "' salvo");
	}
	
	public List<Livro> todosLivros() {
		return manager.createNamedQuery("Livro.todosLivros", Livro.class).getResultList();
	}
	
	@PostConstruct
	void aposCriacao() {
		System.out.println("LivroDao criado!");
	}

	@Interceptors({LogLivros.class})
	public List<Livro> livrosPeloNome(String nome) {
		return manager.createNamedQuery("Livro.buscaLivrosPeloNome", Livro.class)
				.setParameter("pTitulo", "%" + nome + "%")
				.getResultList();
	}
	
}

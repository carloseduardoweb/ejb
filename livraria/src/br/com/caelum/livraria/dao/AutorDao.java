package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.model.Autor;

@Stateless
//@TransactionManagement(TransactionManagementType.CONTAINER) //optional, this is the default JTA value.
@TransactionAttribute(TransactionAttributeType.MANDATORY) // Apply to any methods, since that method hasn't any annotation override.
public class AutorDao {
	
//	@Inject
//	private UserTransaction tx; // Only apply to BMTs (Bean Managed Transactions).

	@PersistenceContext
	private EntityManager manager;
	
	@PostConstruct
	void aposCriacao() {
		System.out.println("AutorDao criado!");
	}

	//@TransactionAttribute(TransactionAttributeType.REQUIRED) //optional, this is the default JTA value in CMTs (Container Managed Transactions).
	public void salva(Autor autor) {
		System.out.println("Salvando o autor '" + autor.getNome() + "'");
		
		manager.persist(autor);		
		
		System.out.println("Autor '" + autor.getNome() + "' salvo");
		
//		throw new RuntimeException("Ocorreu um erro externo.");
	}
	
	public List<Autor> todosAutores() {
		return manager.createNamedQuery("Autor.todosAutores", Autor.class).getResultList();
	}

	public Autor buscaPorId(Integer autorId) {
		return manager.find(Autor.class, autorId);
	}
	
}

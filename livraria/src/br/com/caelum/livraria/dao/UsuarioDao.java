package br.com.caelum.livraria.dao;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.model.Usuario;

@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class UsuarioDao {

	@PersistenceContext
	private EntityManager manager;

	public Usuario buscaPeloLogin(String login) {
		return manager.createNamedQuery("Usuario.buscaPeloLogin", Usuario.class)
				.setParameter("pLogin", login)
				.getResultList()
				.stream().findFirst().orElse(null);
	}
	
	@PostConstruct
	void aposCriacao() {
		System.out.println("UsuarioDao criado!");
	}
	
}

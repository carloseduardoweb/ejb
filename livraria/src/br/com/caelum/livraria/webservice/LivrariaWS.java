package br.com.caelum.livraria.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.model.Livro;

@WebService
@Stateless
public class LivrariaWS {
	
	@Inject
	private LivroDao dao;

	@WebResult(name = "livro")
	public List<Livro> buscaLivroPeloNome(@WebParam(name = "titulo") String nome) {
		System.out.println("Chamando buscaLivroPeloNome('" + nome + "')");
		return dao.livrosPeloNome(nome);
	}
}

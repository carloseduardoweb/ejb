package br.com.caelum.livraria.test;

import java.rmi.RemoteException;

import br.com.caelum.livraria.webservice.LivrariaWS;
import br.com.caelum.livraria.webservice.LivrariaWSProxy;
import br.com.caelum.livraria.webservice.Livro;

public class TesteRequestSoapComJava {

	public static void main(String[] args) throws RemoteException {

		LivrariaWS cliente = new LivrariaWSProxy();
		Livro[] livros = cliente.buscaLivroPeloNome("livro");
		
		for (Livro livro : livros) {
			System.out.println("------------------");
			System.out.println("Título: " + livro.getTitulo());
			System.out.println("Autor: " + livro.getAutor().getNome());
		}
		
		System.out.println("------------------");
	}

}

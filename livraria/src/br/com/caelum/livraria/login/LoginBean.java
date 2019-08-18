package br.com.caelum.livraria.login;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.caelum.livraria.bean.MenuBean;
import br.com.caelum.livraria.model.Usuario;
import br.com.caelum.livraria.service.UsuarioService;

@Model
public class LoginBean {
	
	private Usuario usuario = new Usuario();
	
	@Inject
	private UsuarioService usuarioService;
	
	@Inject
	private UsuarioLogadoBean usuarioLogado;
	
	@Inject
	private MenuBean menu;

	public Usuario getUsuario() {
		return usuario;
	}
	
	public String efetuaLogin() {
		
		Usuario usuarioEncontrado = usuarioService.buscaPeloLogin(usuario.getLogin());
		
		if(usuarioEncontrado!= null && possuiMesmaSenha(usuarioEncontrado)) {
			usuarioLogado.logar(usuarioEncontrado);
			return menu.paginaLivros();
		}
		
		criaMensagem("Usuário não encontrado!");
		limparForm();
		
		return menu.paginaLogin();
	}
	
	public String efetuaLogout() {
		usuarioLogado.deslogar();
		return menu.paginaLogin();
	}

	
	private void limparForm() {
		usuario = new Usuario();
	}

	private void criaMensagem(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, ""));
	}

	private boolean possuiMesmaSenha(Usuario usuarioEncontrado) {
		return usuarioEncontrado.getSenha().equals(usuario.getSenha());
	}
}

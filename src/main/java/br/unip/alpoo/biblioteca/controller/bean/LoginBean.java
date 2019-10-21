package br.unip.alpoo.biblioteca.controller.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.unip.alpoo.biblioteca.model.entidade.Usuario;
import br.unip.alpoo.biblioteca.model.negocio.UsuarioBO;
import br.unip.alpoo.biblioteca.util.MensagemUtil;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean implements Serializable {

	private final String loging = "admin";
	private final String senha = "123";

	public static final String USUARIO_SESSAO = "usuario";
	private static final long serialVersionUID = 1L;

	private UsuarioBO usuarioBO;
	private Usuario usuario;
	private boolean autenticado;

	public LoginBean() {
		super();
		usuarioBO = new UsuarioBO();
		usuario = new Usuario();

	}

	public String efetuarLogin() {
		Usuario usuarioAdmin = null;
		usuarioAdmin = usuarioBO.pesquisarUsuario(this.usuario);
		if ((usuarioAdmin == null)
				&& (usuario.getLogin().equalsIgnoreCase(loging) && usuario.getSenha().equalsIgnoreCase(senha))) {
			usuarioAdmin = new Usuario();
			usuarioAdmin.setLogin(loging);
			usuarioAdmin.setSenha(senha);
			usuarioBO.inserir(usuarioAdmin);
			return "index?faces-redirect=true";

		} else if (usuarioAdmin == null) {
			setAutenticado(false);
			this.usuario = new Usuario();
			MensagemUtil.addMensagemInformativa("Login inválido - ", "usuario ou senha inválido! ");
			return "";
			// return "login?faces-redirect=true";
		} else {
			HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			sessao.setAttribute(USUARIO_SESSAO, usuarioAdmin);
			setAutenticado(true);
			return "index?faces-redirect=true";
		}

	}

	public String efetuarLogout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();
		this.usuario = new Usuario();
		setAutenticado(false);
		return "login?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public boolean isAutenticado() {
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		usuario = (Usuario) sessao.getAttribute(USUARIO_SESSAO);
		if (usuario == null) {
			autenticado = false;
			usuario = new Usuario();
		} else {
			autenticado = true;
		}
		return autenticado;
	}

	public static Usuario obterUsuario() {
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		Usuario usuario = (Usuario) sessao.getAttribute(USUARIO_SESSAO);
		return usuario;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public String getLoging() {
		return loging;
	}

	public String getSenha() {
		return senha;
	}

}

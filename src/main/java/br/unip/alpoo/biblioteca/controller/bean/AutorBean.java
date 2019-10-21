package br.unip.alpoo.biblioteca.controller.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.unip.alpoo.biblioteca.model.entidade.Autor;
import br.unip.alpoo.biblioteca.model.negocio.AutorBO;
import br.unip.alpoo.biblioteca.util.MensagemUtil;

@ManagedBean(name = "autorBean")
@RequestScoped
public class AutorBean {

	AutorBO autorBO;
	private Autor autor;
	private List<Autor> listaAutor;

	public AutorBean() {
		super();
		autorBO = new AutorBO();
		autor = new Autor();
	}

	
	public void salvar() {

		if (autor.getId() == null) {
			autorBO.inserir(autor);
		} else {
			autorBO.atualizar(autor);
	
		}
		MensagemUtil.addMensagemInformativa("Sucesso - ","processo gravação realizada com sucesso! ");

		autor = new Autor();
		listaAutor = autorBO.listarTodos();
	}

	
	public void remover(Autor autor) {
		autorBO.remover(autor);
		listaAutor = autorBO.listarTodos();
		MensagemUtil.addMensagemInformativa("Sucesso - ","processo remoção realizada com sucesso! ");

	}

	public List<Autor> getListaAutor() {
		if (listaAutor == null) {
			listaAutor = autorBO.listarTodos();
		}

		return listaAutor;
	}

	public void setListaAutor(List<Autor> listaAutor) {
		this.listaAutor = listaAutor;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}

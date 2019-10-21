package br.unip.alpoo.biblioteca.controller.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.unip.alpoo.biblioteca.model.entidade.Categoria;
import br.unip.alpoo.biblioteca.model.negocio.CategoriaBO;
import br.unip.alpoo.biblioteca.util.MensagemUtil;

@ManagedBean(name = "categoriaBean")
@RequestScoped
public class CategoriaBean {

	private CategoriaBO categoriaBO;
	private Categoria categoria;
	private List<Categoria> listaCategoria;

	public CategoriaBean() {
		super();
		categoriaBO = new CategoriaBO();
		categoria = new Categoria();

	}

	public void salvar() {

		if (categoria.getId() == null) {
			categoriaBO.inserir(categoria);
		} else {
			categoriaBO.atualizar(categoria);
		}
		MensagemUtil.addMensagemInformativa("Sucesso - ","processo gravação realizada com sucesso! ");

		categoria = new Categoria();
		listaCategoria = categoriaBO.listarTodos();
	}

	public void remover(Categoria categoria) {
		categoriaBO.remover(categoria);
		listaCategoria = categoriaBO.listarTodos();
		MensagemUtil.addMensagemInformativa("Sucesso - ","processo remoção realizada com sucesso! ");

	}

	public List<Categoria> getListaCategoria() {
		if (listaCategoria == null) {
			listaCategoria = categoriaBO.listarTodos();
		}
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}

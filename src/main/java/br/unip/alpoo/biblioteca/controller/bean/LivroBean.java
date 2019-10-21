package br.unip.alpoo.biblioteca.controller.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.unip.alpoo.biblioteca.model.entidade.Autor;
import br.unip.alpoo.biblioteca.model.entidade.Categoria;
import br.unip.alpoo.biblioteca.model.entidade.Editora;
import br.unip.alpoo.biblioteca.model.entidade.Livro;
import br.unip.alpoo.biblioteca.model.negocio.AutorBO;
import br.unip.alpoo.biblioteca.model.negocio.CategoriaBO;
import br.unip.alpoo.biblioteca.model.negocio.EditoraBO;
import br.unip.alpoo.biblioteca.model.negocio.LivroBO;
import br.unip.alpoo.biblioteca.util.MensagemUtil;

@ManagedBean(name = "livroBean")
@RequestScoped
public class LivroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private LivroBO livroBO;
	private Livro livro;
	private List<Livro> listaLivro;

	private CategoriaBO categoriaBO;
	private Integer idCategoria;

	private EditoraBO editoraBO;
	private Integer idEditora;

	AutorBO autorBO;
	private Integer idAutor;
	private List<Autor> listaAutor;

	public LivroBean() {
		super();
		categoriaBO = new CategoriaBO();
		editoraBO = new EditoraBO();
		livroBO = new LivroBO();
		autorBO = new AutorBO();
		livro = new Livro();
		listaAutor = new ArrayList<Autor>();
	}

	public void salvar() {

		Categoria categoria = categoriaBO.pesquisarPorID(idCategoria);
		livro.setCategoria(categoria);

		Editora editora = editoraBO.pesquisarPorID(idEditora);
		livro.setEditora(editora);

		livro.setAutores(listaAutor);

		if (livro.getId() == null) {
			livroBO.inserir(livro);
		} else {
			livroBO.atualizar(livro);
		}
		MensagemUtil.addMensagemInformativa("Sucesso - ","processo gravação realizada com sucesso! ");

		livro = new Livro();
		idCategoria = null;
		idEditora = null;
		listaAutor = new ArrayList<Autor>();
		listaLivro = livroBO.listarTodos();
	}

	public void alterar(Livro livro) {
		this.livro = livro;
		idCategoria = livro.getCategoria().getId();
		idEditora = livro.getCategoria().getId();
		listaAutor = livro.getAutores();
	}

	public void remover(Livro livro) {
		livroBO.remover(livro);
		listaLivro = livroBO.listarTodos();
		MensagemUtil.addMensagemInformativa("Sucesso - ","processo remoção realizada com sucesso! ");

	}

	public List<Livro> getListaLivro() {
		if (listaLivro == null) {
			listaLivro = livroBO.listarTodos();
		}

		return listaLivro;
	}

	public void setListaLivro(List<Livro> listaLivro) {
		this.listaLivro = listaLivro;
	}

	public void adicionarAutor() {
		Autor autor = autorBO.pesquisarPorID(idAutor);
		listaAutor.add(autor);
	}

	public void removerAutor(Autor autor) {
		Autor autorASerExcluido = null;

		for (Autor autorDaVez : listaAutor) {
			if (autor.getId() == autorDaVez.getId())
				autorASerExcluido = autorDaVez;
		}

		listaAutor.remove(autorASerExcluido);
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Autor> getListaAutor() {
		return listaAutor;
	}

	public void setListaAutor(List<Autor> listaAutor) {
		this.listaAutor = listaAutor;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Integer getIdEditora() {
		return idEditora;
	}

	public void setIdEditora(Integer idEditora) {
		this.idEditora = idEditora;
	}

	public Integer getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}
}

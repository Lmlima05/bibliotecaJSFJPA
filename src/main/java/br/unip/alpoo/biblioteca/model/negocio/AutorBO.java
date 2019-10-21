package br.unip.alpoo.biblioteca.model.negocio;

import java.util.List;

import br.unip.alpoo.biblioteca.model.entidade.Autor;
import br.unip.alpoo.biblioteca.model.persistencia.AutorDAO;

public class AutorBO extends GenericoBO<Autor> {

	public AutorBO() {
		super();
		genericoDAO = new AutorDAO(Autor.class, entityManager);
	}

	@Override
	public void inserir(Autor entidade) {
		genericoDAO.inserir(entidade);

	}

	@Override
	public void remover(Autor entidade) {
		genericoDAO.remover(entidade);

	}

	@Override
	public void atualizar(Autor entidade) {
		genericoDAO.atualizar(entidade);
	}

	@Override
	public List<Autor> listarTodos() {
		return genericoDAO.listarTodos();
	}

	@Override
	public Autor pesquisarPorID(Integer id) {
		return (Autor) genericoDAO.pesquisarPorID(id);
	}

}

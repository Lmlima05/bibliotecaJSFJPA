package br.unip.alpoo.biblioteca.model.negocio;

import java.util.List;

import br.unip.alpoo.biblioteca.model.entidade.Categoria;
import br.unip.alpoo.biblioteca.model.persistencia.CategoriaDAO;

public class CategoriaBO extends GenericoBO<Categoria> {

	public CategoriaBO() {
		super();
		genericoDAO = new CategoriaDAO(Categoria.class, entityManager);
	}

	@Override
	public void inserir(Categoria entidade) {
		genericoDAO.inserir(entidade);
	}

	@Override
	public void remover(Categoria entidade) {
		genericoDAO.remover(entidade);
	}

	@Override
	public void atualizar(Categoria entidade) {
		genericoDAO.atualizar(entidade);

	}

	@Override
	public List<Categoria> listarTodos() {
		return genericoDAO.listarTodos();
	}
	
	@Override
	public Categoria pesquisarPorID(Integer id) {
		return (Categoria) genericoDAO.pesquisarPorID(id);
	}

}

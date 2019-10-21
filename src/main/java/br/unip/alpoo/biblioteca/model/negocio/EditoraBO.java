package br.unip.alpoo.biblioteca.model.negocio;

import java.util.List;

import br.unip.alpoo.biblioteca.model.entidade.Editora;
import br.unip.alpoo.biblioteca.model.persistencia.EditoraDAO;

public class EditoraBO extends GenericoBO<Editora> {

	public EditoraBO() {
		super();
		genericoDAO = new EditoraDAO(Editora.class, entityManager);
	}

	@Override
	public void inserir(Editora entidade) {
		genericoDAO.inserir(entidade);

	}

	@Override
	public void remover(Editora entidade) {
		genericoDAO.remover(entidade);

	}

	@Override
	public void atualizar(Editora entidade) {
		genericoDAO.atualizar(entidade);
	}

	@Override
	public List<Editora> listarTodos() {
		return genericoDAO.listarTodos();
	}

	@Override
	public Editora pesquisarPorID(Integer id) {
		return (Editora) genericoDAO.pesquisarPorID(id);
	}
}

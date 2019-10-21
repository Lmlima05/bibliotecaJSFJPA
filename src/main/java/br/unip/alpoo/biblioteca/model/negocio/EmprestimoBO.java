package br.unip.alpoo.biblioteca.model.negocio;

import java.util.List;

import br.unip.alpoo.biblioteca.model.entidade.Emprestimo;
import br.unip.alpoo.biblioteca.model.persistencia.EmprestimoDAO;

public class EmprestimoBO extends GenericoBO<Emprestimo> {

	public EmprestimoBO() {
		super();
		genericoDAO = new EmprestimoDAO(Emprestimo.class, entityManager);
	}

	@Override
	public void inserir(Emprestimo entidade) {
		genericoDAO.inserir(entidade);

	}

	@Override
	public void remover(Emprestimo entidade) {
	//	genericoDAO.remover(entidade);

	}

	@Override
	public void atualizar(Emprestimo entidade) {
		genericoDAO.atualizar(entidade);
	}

	@Override
	public List<Emprestimo> listarTodos() {
	//	return genericoDAO.listarTodos();
		return null;
	}

	@Override
	public Emprestimo pesquisarPorID(Integer id) {
		return null;
	}

}

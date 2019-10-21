package br.unip.alpoo.biblioteca.model.negocio;

import java.util.List;

import br.unip.alpoo.biblioteca.model.entidade.Livro;
import br.unip.alpoo.biblioteca.model.persistencia.LivroDAO;

public class LivroBO extends GenericoBO<Livro> {

	public LivroBO() {
		super();
		genericoDAO = new LivroDAO(Livro.class, entityManager);
	}
	@Override
	public void inserir(Livro entidade) {
		genericoDAO.inserir(entidade);
		
	}

	@Override
	public void remover(Livro entidade) {
	genericoDAO.remover(entidade);

	}

	@Override
	public void atualizar(Livro entidade) {
		genericoDAO.atualizar(entidade);
	}

	@Override
	public List<Livro> listarTodos() {
		return genericoDAO.listarTodos();
	}
	
	@Override
	public Livro pesquisarPorID(Integer id) {
		return (Livro) genericoDAO.pesquisarPorID(id);
	}
	public List<Livro> listarLivrosDisponiveisParaEmprestimo() {
		return ((LivroDAO) genericoDAO).listarLivrosDisponiveisParaEmprestimo();
	}
	public List<Livro> listarLivrosEmprestados() {
		return ((LivroDAO) genericoDAO).listarLivrosEmprestados();
	}	
}

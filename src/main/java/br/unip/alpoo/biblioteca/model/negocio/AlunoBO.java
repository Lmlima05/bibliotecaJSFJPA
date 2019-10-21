package br.unip.alpoo.biblioteca.model.negocio;

import java.util.List;

import br.unip.alpoo.biblioteca.model.entidade.Aluno;
import br.unip.alpoo.biblioteca.model.persistencia.AlunoDAO;

public class AlunoBO extends GenericoBO<Aluno> {

	public AlunoBO() {
		super();
		genericoDAO = new AlunoDAO(Aluno.class, entityManager);
	}

	@Override
	public void inserir(Aluno entidade) {
		genericoDAO.inserir(entidade);
	}

	
	@Override
	public void remover(Aluno entidade) {
		genericoDAO.remover(entidade);
	}
	
	@Override
	public void atualizar(Aluno entidade) {
		genericoDAO.atualizar(entidade);

	}

	@Override
	public List<Aluno> listarTodos() {
		return 	genericoDAO.listarTodos();
	}

	@Override
	public Aluno pesquisarPorID(Integer id) {
		return (Aluno) genericoDAO.pesquisarPorID(id);

	}
	
	
}

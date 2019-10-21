package br.unip.alpoo.biblioteca.model.negocio;

import java.util.List;

import br.unip.alpoo.biblioteca.model.entidade.Funcionario;
import br.unip.alpoo.biblioteca.model.persistencia.FuncionarioDAO;

public class FuncionarioBO extends GenericoBO<Funcionario> {

	public FuncionarioBO() {
		super();
		genericoDAO = new FuncionarioDAO(Funcionario.class, entityManager);
	}

	@Override
	public void inserir(Funcionario entidade) {
		genericoDAO.inserir(entidade);

	}

	@Override
	public void remover(Funcionario entidade) {
		genericoDAO.remover(entidade);

	}

	@Override
	public void atualizar(Funcionario entidade) {
		genericoDAO.atualizar(entidade);
	}

	@Override
	public List<Funcionario> listarTodos() {
		return genericoDAO.listarTodos();
	}

	@Override
	public Funcionario pesquisarPorID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}	
	public boolean existeFuncionarioCadastrado() {
		boolean existeFuncionario = ((FuncionarioDAO) genericoDAO).existeFuncionarioCadastrado();
		return existeFuncionario;
	}
}

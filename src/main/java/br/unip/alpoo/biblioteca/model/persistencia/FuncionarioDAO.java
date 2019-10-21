package br.unip.alpoo.biblioteca.model.persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import br.unip.alpoo.biblioteca.model.entidade.Funcionario;

public class FuncionarioDAO extends GenericoDAO<Funcionario> {

	public FuncionarioDAO(Class<Funcionario> classeDaEntidade , EntityManager entityManager) {
		super(classeDaEntidade, entityManager);
	}

	public boolean existeFuncionarioCadastrado() {
		List<Funcionario> listaDeFuncionarios = listarTodos();

		if (listaDeFuncionarios != null && listaDeFuncionarios.size() > 0) {
			return true;
		}

		return false;
	}

}
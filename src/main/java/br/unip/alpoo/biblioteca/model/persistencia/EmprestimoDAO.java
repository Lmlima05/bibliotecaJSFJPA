package br.unip.alpoo.biblioteca.model.persistencia;

import javax.persistence.EntityManager;

import br.unip.alpoo.biblioteca.model.entidade.Emprestimo;

public class EmprestimoDAO extends GenericoDAO<Emprestimo> {

	public EmprestimoDAO(Class<Emprestimo> classeDaEntidade, EntityManager entityManager) {
		super(classeDaEntidade, entityManager);

	}

}

package br.unip.alpoo.biblioteca.model.persistencia;

import javax.persistence.EntityManager;

import br.unip.alpoo.biblioteca.model.entidade.Editora;

public class EditoraDAO extends GenericoDAO<Editora> {

	public EditoraDAO(Class<Editora> classeDaEntidade, EntityManager entityManager) {
		super(classeDaEntidade, entityManager);
		// TODO Auto-generated constructor stub
	}

}

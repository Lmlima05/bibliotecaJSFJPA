package br.unip.alpoo.biblioteca.model.persistencia;

import javax.persistence.EntityManager;

import br.unip.alpoo.biblioteca.model.entidade.Autor;

public class AutorDAO extends GenericoDAO<Autor> {

	public AutorDAO(Class<Autor> classeDaEntidade, EntityManager entityManager) {
		super(classeDaEntidade, entityManager);
		// TODO Auto-generated constructor stub
	}

}

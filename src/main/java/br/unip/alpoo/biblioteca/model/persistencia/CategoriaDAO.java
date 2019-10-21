package br.unip.alpoo.biblioteca.model.persistencia;

import javax.persistence.EntityManager;

import br.unip.alpoo.biblioteca.model.entidade.Categoria;

public class CategoriaDAO extends GenericoDAO<Categoria> {


	public CategoriaDAO(Class<Categoria> classeDaEntidade, EntityManager entityManager) {
		super(classeDaEntidade, entityManager);
		// TODO Auto-generated constructor stub
	}

}

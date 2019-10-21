package br.unip.alpoo.biblioteca.model.persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import br.unip.alpoo.biblioteca.model.entidade.GenericoEntidade;

public class GenericoDAO<T extends GenericoEntidade>  {
	
	protected Class<T> classeDaEntidade;
	protected EntityManager entityManager;

	public GenericoDAO(Class<T> classeDaEntidade,EntityManager entityManager ) {
		this.classeDaEntidade = classeDaEntidade;
		this.entityManager = entityManager;
	}


	public void inserir(T entidade) {
		entityManager.persist(entidade);
	}
	

	public void inserirTodos(List<T> listaEntidades) {
		for (T t : listaEntidades) {
			entityManager.persist(t);
		}	
	}


	public void remover(T entidade) {
		entityManager.remove(entityManager.merge(entidade));
	}


	public void removerPorId(Integer id) {
		T entity = entityManager.find(classeDaEntidade, id);
		entityManager.remove(entity);	
	}


	public void atualizar(T entidade) {
		entityManager.merge(entidade);	
	}
	

	public T pesquisarPorID(Integer id) {
		return entityManager.find(classeDaEntidade, id);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<T> listarTodos(){
		return entityManager.createQuery("select t from " + classeDaEntidade.getSimpleName() + " t").getResultList();
	}





	

}

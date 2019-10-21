package br.unip.alpoo.biblioteca.model.negocio;

import java.util.List;

import javax.persistence.EntityManager;

import br.unip.alpoo.biblioteca.model.entidade.GenericoEntidade;
import br.unip.alpoo.biblioteca.model.hibernate.HibernateUtil;
import br.unip.alpoo.biblioteca.model.persistencia.GenericoDAO;

public abstract class GenericoBO<T extends GenericoEntidade>  {

	protected GenericoDAO genericoDAO;
	protected EntityManager entityManager;
	
	public GenericoBO() {
		super();
		entityManager = HibernateUtil.getEntityManager();
	}

	public abstract void inserir(T entidade) ;

	public abstract void remover(T entidade) ;

	public abstract void atualizar(T entidade) ;
	
	public abstract List<T> listarTodos();
	
	public abstract T pesquisarPorID(Integer id) ;


}

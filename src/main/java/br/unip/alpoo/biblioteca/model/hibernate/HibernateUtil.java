package br.unip.alpoo.biblioteca.model.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HibernateUtil {

	private static final String PERSISTENCE_UNIT_NAME = "bibliotecaPersistence";
	private static ThreadLocal<EntityManager> manager = new ThreadLocal<EntityManager>();
	private static EntityManagerFactory factory;
	
	public static boolean isEntityManagerOpen() {
		return HibernateUtil.manager.get() != null && HibernateUtil.manager.get().isOpen();
	}
	
	public static void closeEntityManagerFactory() {
		closeEntityManager();
		HibernateUtil.factory.close();
	}
	
	public static void closeEntityManager() {
		EntityManager em = HibernateUtil.manager.get();
		if (em != null) {
			EntityTransaction tx = em.getTransaction();
			if (tx.isActive()) { 
				tx.commit();
			}
			em.close();
			HibernateUtil.manager.set(null);
			HibernateUtil.manager.remove();
		}
	}
	
	public static EntityManager getEntityManager() {
		if (HibernateUtil.factory == null) {
			HibernateUtil.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		EntityManager em = HibernateUtil.manager.get();
		if (em == null || !em.isOpen()) {
			em = HibernateUtil.factory.createEntityManager();
			HibernateUtil.manager.set(em);
		}
		return em;
	}
}
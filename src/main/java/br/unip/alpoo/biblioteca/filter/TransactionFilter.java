package br.unip.alpoo.biblioteca.filter;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.unip.alpoo.biblioteca.model.hibernate.HibernateUtil;
import br.unip.alpoo.biblioteca.util.MensagemUtil;


@WebFilter("/*")
public class TransactionFilter implements Filter {
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		EntityManager em  = HibernateUtil.getEntityManager();	
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			chain.doFilter(request, response);
			tx.commit();
		} catch (Exception e) {
			
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			MensagemUtil.addMensagemDeErro("Erro -  ", "Detalhe do erro : " + e.getClass().getName() + " - " + e.getMessage());
			throw new RuntimeException( " Erro -  Detalhe do erro :  - "+ e.getClass().getName() + " - " + e.getMessage(), e);
		
			
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}
	
	@Override
	public void destroy() {
		HibernateUtil.closeEntityManagerFactory();
	}
}
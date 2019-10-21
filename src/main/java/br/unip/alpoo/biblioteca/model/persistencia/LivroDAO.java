package br.unip.alpoo.biblioteca.model.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.unip.alpoo.biblioteca.model.entidade.Emprestimo;
import br.unip.alpoo.biblioteca.model.entidade.Livro;

public class LivroDAO extends GenericoDAO<Livro> {
	


	public LivroDAO(Class<Livro> classeDaEntidade , EntityManager entityManager) {
		super(classeDaEntidade, entityManager);
	
	}
	



	public List<Livro> listarLivrosDisponiveisParaEmprestimo() {
		
		List<Livro> todosLivros = listarTodos();
		List<Livro> livrosDisponiveis = new ArrayList<Livro>();
		
		for(Livro livro : todosLivros){
	
			List<Emprestimo> listaEmprestimo = livro.getListaEmprestimo();
			
			boolean todosEmprestimosTemDataDevolucao = true;
			
			for(Emprestimo emprestimo : listaEmprestimo){
				if(emprestimo.getDataDevolucao() == null)
					todosEmprestimosTemDataDevolucao = false;
			}
			
			if(todosEmprestimosTemDataDevolucao)
				livrosDisponiveis.add(livro);
		}
		
		return livrosDisponiveis;
	}
	

	public List<Livro> listarLivrosEmprestados() {
		
		List<Livro> todosLivros = listarTodos();		
		List<Livro> livrosEmprestados = new ArrayList<Livro>();
		
		for(Livro livro : todosLivros){
				
			List<Emprestimo> listaEmprestimo = livro.getListaEmprestimo();
			
			for(Emprestimo emprestimo : listaEmprestimo){
				if(emprestimo.getDataDevolucao() == null)
					livrosEmprestados.add(livro);
			}
		}
		
		return livrosEmprestados;
	}
}

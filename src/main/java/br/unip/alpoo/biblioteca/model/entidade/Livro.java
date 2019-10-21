package br.unip.alpoo.biblioteca.model.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Livro implements GenericoEntidade{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String isbn;
	
	@ManyToOne
	@JoinColumn(name="idEditora")
	private Editora editora;
	
	@ManyToOne
	@JoinColumn(name="idCategoria")
	private Categoria categoria;
	
	@ManyToMany
	@JoinTable(name="livroAutor",
				joinColumns={@JoinColumn(name="idLivro")},
				inverseJoinColumns={@JoinColumn(name="idAutor")})
	private List<Autor> autores;

	@OneToMany(mappedBy="livro")
	private List<Emprestimo> listaEmprestimo;
	
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public List<Emprestimo> getListaEmprestimo() {
		listaEmprestimo = listaEmprestimo == null ? new ArrayList<Emprestimo>() : listaEmprestimo;
		return listaEmprestimo;
	
	}
	public void setListaEmprestimo(List<Emprestimo> listaEmprestimo) {
		this.listaEmprestimo = listaEmprestimo;
	}
	
	
}

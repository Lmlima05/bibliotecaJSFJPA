package br.unip.alpoo.biblioteca.model.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Aluno extends Pessoa{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String turma;
	private Integer matricula;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="idAluno")
	private List<Telefone> listaTelefone ;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="idEndereco")
	
	private Endereco endereco;
	
	
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public Endereco getEndereco() {
		return endereco;
	}
	public List<Telefone> getListaTelefone() {
		listaTelefone = listaTelefone == null ? new ArrayList<Telefone>() : listaTelefone;
		return listaTelefone;
	}
	public void setListaTelefone(List<Telefone> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}

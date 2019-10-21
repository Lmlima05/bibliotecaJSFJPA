package br.unip.alpoo.biblioteca.model.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Funcionario extends Pessoa{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="idusuario")
	Usuario usuario;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="idfuncionario")
	private List<Telefone> listaTelefone; 
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="idendereco")
	private Endereco endereco;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Telefone> getListaTelefone() {
		listaTelefone = listaTelefone == null ? new ArrayList<Telefone>() : listaTelefone;
		return listaTelefone;
	}
	public void setListaTelefone(List<Telefone> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}

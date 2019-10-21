package br.unip.alpoo.biblioteca.controller.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.unip.alpoo.biblioteca.model.entidade.Aluno;
import br.unip.alpoo.biblioteca.model.entidade.Endereco;
import br.unip.alpoo.biblioteca.model.entidade.Telefone;
import br.unip.alpoo.biblioteca.model.negocio.AlunoBO;
import br.unip.alpoo.biblioteca.util.MensagemUtil;

@ManagedBean(name = "alunoBean")
@RequestScoped
public class AlunoBean {

	private AlunoBO alunoBO;
	private Aluno aluno;
	private Telefone telefoneFixo;
	private Telefone telefoneCelular;
	private List<Aluno> listaAluno;

	public AlunoBean() {
		alunoBO = new AlunoBO();
		aluno = new Aluno();
		telefoneFixo = new Telefone();
		telefoneCelular = new Telefone();
		aluno.setEndereco(new Endereco());
	}


	public void salvar() {

		if (aluno.getId() == null) {
			vincularTelefones();
			alunoBO.inserir(aluno);

		} else {
			aluno.getListaTelefone().clear();
			vincularTelefones();
			alunoBO.atualizar(aluno);

		}
		MensagemUtil.addMensagemInformativa("Sucesso - ","processo gravação realizada com sucesso! ");

		telefoneFixo = new Telefone();
		telefoneCelular = new Telefone();
		aluno = new Aluno();
	
	}

	public void vincularTelefones() {
		telefoneFixo.setFixo(true);
		aluno.getListaTelefone().add(telefoneFixo);
		aluno.getListaTelefone().add(telefoneCelular);
	}

	public void alterar(Aluno leitor) {
		this.aluno = leitor;
		for (Telefone telefone : leitor.getListaTelefone()) {
			if (telefone.isFixo()) {
				this.telefoneFixo = telefone;
			} else {
				this.telefoneCelular = telefone;
			}
		}
	}

	public void remover(Aluno aluno) {
		alunoBO.remover(aluno);
		listaAluno = alunoBO.listarTodos();
		MensagemUtil.addMensagemInformativa("Sucesso - ","processo remoção realizada com sucesso! ");

	}


	public List<Aluno> getListaAluno() {
		if (listaAluno == null) {
			listaAluno = alunoBO.listarTodos();
		}
		return listaAluno;
	}

	public void setListaAluno(List<Aluno> listaAluno) {
		this.listaAluno = listaAluno;
	}


	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Telefone getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(Telefone telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public Telefone getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(Telefone telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

}

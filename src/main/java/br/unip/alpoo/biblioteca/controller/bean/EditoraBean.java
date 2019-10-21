package br.unip.alpoo.biblioteca.controller.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.unip.alpoo.biblioteca.model.entidade.Editora;
import br.unip.alpoo.biblioteca.model.entidade.Endereco;
import br.unip.alpoo.biblioteca.model.entidade.Telefone;
import br.unip.alpoo.biblioteca.model.negocio.EditoraBO;
import br.unip.alpoo.biblioteca.util.MensagemUtil;

@ManagedBean(name = "editoraBean")
@RequestScoped
public class EditoraBean {

	private EditoraBO editoraBO ;
	private Editora editora;
	private Telefone telefoneFixo;
	private Telefone telefoneCelular;
	private List<Editora> listaEditora;

	public EditoraBean() {
		editora = new Editora();
		editora.setEndereco(new Endereco());
		editoraBO = new EditoraBO();

		telefoneFixo = new Telefone();
		telefoneCelular = new Telefone();

	}

	public void salvar() {

		if (editora.getId() == null) {
			vincularTelefones();
			editoraBO.inserir(editora);
		} else {
			editora.getListaTelefone().clear();
			vincularTelefones();
			editoraBO.atualizar(editora);
		}
		MensagemUtil.addMensagemInformativa("Sucesso - ","processo gravação realizada com sucesso! ");

		telefoneFixo = new Telefone();
		telefoneCelular = new Telefone();
		editora = new Editora();
	}

	public void vincularTelefones() {
		telefoneFixo.setFixo(true);
		editora.getListaTelefone().add(telefoneFixo);
		editora.getListaTelefone().add(telefoneCelular);
	}

	public void alterar(Editora editora) {
		this.editora = editora;
		for (Telefone telefone : editora.getListaTelefone()) {
			if (telefone.isFixo()) {
				this.telefoneFixo = telefone;
			} else {
				this.telefoneCelular = telefone;
			}
		}
	}
	public void remover(Editora editora) {
		editoraBO.remover(editora);
		listaEditora = editoraBO.listarTodos();
		MensagemUtil.addMensagemInformativa("Sucesso - ","processo remoção realizada com sucesso! ");

	}

	public List<Editora> getListaEditora() {
		if (listaEditora == null) {
			listaEditora = editoraBO.listarTodos();
		}
		return listaEditora;
	}

	public void setListaEditora(List<Editora> listaEditora) {
		this.listaEditora = listaEditora;
	}

	
	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
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

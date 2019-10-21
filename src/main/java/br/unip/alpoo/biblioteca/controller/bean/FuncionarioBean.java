package br.unip.alpoo.biblioteca.controller.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.unip.alpoo.biblioteca.model.entidade.Endereco;
import br.unip.alpoo.biblioteca.model.entidade.Funcionario;
import br.unip.alpoo.biblioteca.model.entidade.Telefone;
import br.unip.alpoo.biblioteca.model.entidade.Usuario;
import br.unip.alpoo.biblioteca.model.negocio.FuncionarioBO;
import br.unip.alpoo.biblioteca.model.negocio.UsuarioBO;
import br.unip.alpoo.biblioteca.util.MensagemUtil;

@ManagedBean(name = "funcionarioBean")
@RequestScoped
public class FuncionarioBean {
	
	
	private FuncionarioBO funcionarioBO ;
	private UsuarioBO usuarioBO;

	private Funcionario funcionario;
	private Telefone telefoneFixo;
	private Telefone telefoneCelular ;
	private List<Funcionario> listaFuncionario;


	//private boolean redirecionarParaLogin;
	//private boolean campoAdminDesabilitado;

	public FuncionarioBean(){
		funcionarioBO = new FuncionarioBO();
		usuarioBO = new UsuarioBO();
		funcionario = new Funcionario();

		funcionario.setEndereco(new Endereco());
		Usuario usuario = new Usuario();
		usuario.setFuncionario(funcionario);
		funcionario.setUsuario(usuario);
		
		
		telefoneFixo = new Telefone();
		telefoneCelular = new Telefone();
		
	}

	
	public void salvar(){
		
	/*	if(isCampoAdminDesabilitado()){
			redirecionarParaLogin = true;
		}*/
		
		if(funcionario.getId() == null){
			vincularTelefones();
			funcionarioBO.inserir(funcionario);
		}else{
			funcionario.getListaTelefone().clear();
			vincularTelefones();
			funcionarioBO.atualizar(funcionario);
		}
		
		telefoneFixo = new Telefone();
		telefoneCelular = new Telefone();
		funcionario = new Funcionario();
		listaFuncionario = funcionarioBO.listarTodos();
	}
	
	public void vincularTelefones(){
		telefoneFixo.setFixo(true);
		funcionario.getListaTelefone().add(telefoneFixo);
		funcionario.getListaTelefone().add(telefoneCelular);
	}
	
	public void alterar(Funcionario funcionario){
		this.funcionario = funcionario;
		for(Telefone telefone : funcionario.getListaTelefone()){
			if(telefone.isFixo()){
				this.telefoneFixo = telefone;
			}else{
				this.telefoneCelular = telefone;
			}
		}
	}
	

	public void remover(Funcionario funcionarioBiblioteca){
		funcionarioBO.remover(funcionarioBiblioteca);
		listaFuncionario = funcionarioBO.listarTodos();
		MensagemUtil.addMensagemInformativa("Sucesso - ","processo remoção realizada com sucesso! ");

	}
	public boolean existeFuncionarioEUsuarioCadastrado(){
		return (funcionarioBO.existeFuncionarioCadastrado() && usuarioBO.existeUsuarioCadastrado());
	}
	/*public void redirecionarParaLogin(){
		if(redirecionarParaLogin)
			navegador.redirecionar("login");
	}
	*/

	public List<Funcionario> getListaFuncionario() {
		if(listaFuncionario == null){
			listaFuncionario = funcionarioBO.listarTodos();
		}
		return listaFuncionario;
	}


	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}




	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
	
	/*public boolean isCampoAdminDesabilitado() {
		campoAdminDesabilitado = !verificadorBean.existeFuncionarioEUsuarioCadastrado();
		return campoAdminDesabilitado;
	}*/
	
}

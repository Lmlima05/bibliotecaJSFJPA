package br.unip.alpoo.biblioteca.controller.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.unip.alpoo.biblioteca.model.entidade.Aluno;
import br.unip.alpoo.biblioteca.model.entidade.Emprestimo;
import br.unip.alpoo.biblioteca.model.entidade.Funcionario;
import br.unip.alpoo.biblioteca.model.entidade.Livro;
import br.unip.alpoo.biblioteca.model.entidade.Usuario;
import br.unip.alpoo.biblioteca.model.negocio.AlunoBO;
import br.unip.alpoo.biblioteca.model.negocio.EmprestimoBO;
import br.unip.alpoo.biblioteca.model.negocio.LivroBO;
import br.unip.alpoo.biblioteca.util.MensagemUtil;

@ManagedBean(name = "emprestimoBean")
@RequestScoped
public class EmprestimoBean {
	
	private EmprestimoBO emprestimoBO;
	private Emprestimo emprestimo;

	private LivroBO livroBO;
	private Integer idLivro;
	private List<Livro> listaLivrosDisponivel;

	private AlunoBO alunoBO;
	private Integer idAluno;

	private LoginBean logadoBean;
	String dataEmprestimoFormatada;
	String dataPrevistaFormatada;

	public EmprestimoBean() {

		emprestimoBO = new EmprestimoBO();
		emprestimo = new Emprestimo();
		livroBO = new LivroBO();
		alunoBO = new AlunoBO();
		emprestimo.setDataEmprestimo(LocalDate.now());
		emprestimo.setDataPrevista(LocalDate.now().plusDays(7));

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataEmprestimoFormatada = emprestimo.getDataEmprestimo().format(formatador);
		dataPrevistaFormatada = emprestimo.getDataPrevista().format(formatador);
	}

	public void realizarEmprestimo() {

		Usuario usuario = LoginBean.obterUsuario();
		
		Livro livro = livroBO.pesquisarPorID(idLivro);
		Aluno aluno = alunoBO.pesquisarPorID(idAluno);
		Funcionario funcionario = usuario.getFuncionario();

		emprestimo.setLivro(livro);
		livro.getListaEmprestimo().add(emprestimo);

		emprestimo.setAluno(aluno);
		emprestimo.setFuncionario(funcionario);

		emprestimoBO.inserir(emprestimo);

		listaLivrosDisponivel = livroBO.listarLivrosDisponiveisParaEmprestimo();

		MensagemUtil.addMensagemInformativa("Sucesso - ", "Empréstimo realizado com sucesso! !!! ");
	}

	public List<Livro> getListaLivrosDisponivel() {
		if (listaLivrosDisponivel == null) {
			listaLivrosDisponivel = livroBO.listarLivrosDisponiveisParaEmprestimo();
		}

		return listaLivrosDisponivel;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public String getDataEmprestimoFormatada() {
		return dataEmprestimoFormatada;
	}

	public String getDataPrevistaFormatada() {
		return dataPrevistaFormatada;
	}

}

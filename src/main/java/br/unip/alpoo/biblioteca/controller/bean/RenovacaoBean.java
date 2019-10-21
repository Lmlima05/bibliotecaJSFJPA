package br.unip.alpoo.biblioteca.controller.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.unip.alpoo.biblioteca.model.entidade.Emprestimo;
import br.unip.alpoo.biblioteca.model.entidade.Livro;
import br.unip.alpoo.biblioteca.model.negocio.EmprestimoBO;
import br.unip.alpoo.biblioteca.model.negocio.LivroBO;
import br.unip.alpoo.biblioteca.util.MensagemUtil;

@ManagedBean(name = "renovacaoBean")
@RequestScoped
public class RenovacaoBean {

	private LivroBO livroBO;
	private Integer idLivro;
	private List<Livro> listaLivrosEmprestado;

	private EmprestimoBO emprestimoBO;
	private Emprestimo emprestimo;
	private String dataEmprestimoFormatada;
	private String dataPrevistaFormatada;
	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public RenovacaoBean() {
		super();
		livroBO = new LivroBO();
		emprestimoBO = new EmprestimoBO();
		emprestimo = new Emprestimo();

	}

	public void alteradoLivroSelecionado() {
		if (idLivro != null) {

			setarEmprestimo();
			dataEmprestimoFormatada = emprestimo.getDataEmprestimo().format(formatador);
			dataPrevistaFormatada = emprestimo.getDataPrevista().format(formatador);

		} else {
			limparCampos();
		}
	}

	public void realizarRenovacao() {
		if (idLivro != null) {
			setarEmprestimo();

			LocalDate dataAtual = LocalDate.now();
			if (dataAtual.isAfter(emprestimo.getDataPrevista())) {

				MensagemUtil.addMensagemDeAviso("Aviso - ", "O empréstimo do livro não pode ser renovado " + "pois a data prevista de devolução já passou.");

			} else {

				LocalDate novaData = emprestimo.getDataPrevista().plusDays(7);
				emprestimo.setDataPrevista(novaData);
				emprestimoBO.atualizar(emprestimo);

				dataEmprestimoFormatada = emprestimo.getDataEmprestimo().format(formatador);
				dataPrevistaFormatada = emprestimo.getDataPrevista().format(formatador);

				listaLivrosEmprestado = livroBO.listarLivrosEmprestados();

				MensagemUtil.addMensagemInformativa("Sucesso - ",
						"Renovação realizada com sucesso! " + "A nova data para devolução " + emprestimo.getDataPrevista().format(formatador));

			}
		} else {
			MensagemUtil.addMensagemDeAviso("Aviso - ", "Selecione um livro para renovar.");
		}

	}
	public List<Livro> getListaLivrosEmprestado() {
		if (listaLivrosEmprestado == null) {
			listaLivrosEmprestado = livroBO.listarLivrosEmprestados();
		}
		return listaLivrosEmprestado;
	}
	
	private void setarEmprestimo() {
		Livro livroSelecionado = getLivroSelecionado();
		Emprestimo emprestimoDoLivroSelecionado = getEmprestimoDoLivroSelecionado(livroSelecionado);
		emprestimo = emprestimoDoLivroSelecionado;
	}

	private Livro getLivroSelecionado() {
		for (Livro livro : listaLivrosEmprestado) {
			if (livro.getId() == idLivro) {
				return livro;
			}
		}

		return null;
	}

	private Emprestimo getEmprestimoDoLivroSelecionado(Livro livroSelecionado) {
		for (Emprestimo emprestimo : livroSelecionado.getListaEmprestimo()) {
			if (emprestimo.getDataDevolucao() == null) {
				return emprestimo;
			}
		}

		return null;
	}

	private void limparCampos() {
		emprestimo = new Emprestimo();
		dataEmprestimoFormatada = "";
		dataPrevistaFormatada = "";
	}

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	
	
	public void setListaLivrosEmprestado(List<Livro> listaLivrosEmprestado) {
		this.listaLivrosEmprestado = listaLivrosEmprestado;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public String getDataEmprestimoFormatada() {
		return dataEmprestimoFormatada;
	}

	public void setDataEmprestimoFormatada(String dataEmprestimoFormatada) {
		this.dataEmprestimoFormatada = dataEmprestimoFormatada;
	}

	public String getDataPrevistaFormatada() {
		return dataPrevistaFormatada;
	}

	public void setDataPrevistaFormatada(String dataPrevistaFormatada) {
		this.dataPrevistaFormatada = dataPrevistaFormatada;
	}
}

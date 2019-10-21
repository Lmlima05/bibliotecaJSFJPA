package br.unip.alpoo.biblioteca.controller.bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.unip.alpoo.biblioteca.model.entidade.Emprestimo;
import br.unip.alpoo.biblioteca.model.entidade.Livro;
import br.unip.alpoo.biblioteca.model.negocio.EmprestimoBO;
import br.unip.alpoo.biblioteca.model.negocio.LivroBO;
import br.unip.alpoo.biblioteca.util.FormatadorDeNumeros;
import br.unip.alpoo.biblioteca.util.MensagemUtil;

@ManagedBean(name = "devolucaoBean")
@RequestScoped
public class DevolucaoBean {

	private LivroBO livroBO;
	private Integer idLivro;
	private List<Livro> listaLivrosEmprestado;

	private EmprestimoBO emprestimoBO;
	private Emprestimo emprestimo;
	private String dataEmprestimoFormatada;
	private String dataPrevistaFormatada;

	private String multa = FormatadorDeNumeros.formatarBigDecimalComoMoeda(new BigDecimal(0.0d));

	public DevolucaoBean() {
		super();
		livroBO = new LivroBO();
		emprestimoBO = new EmprestimoBO();
		emprestimo = new Emprestimo();

	}

	public void alteradoLivroSelecionado() {
		if (idLivro != null) {
			setarEmprestimo();

			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dataEmprestimoFormatada = emprestimo.getDataEmprestimo().format(formatador);
			dataPrevistaFormatada = emprestimo.getDataPrevista().format(formatador);

			LocalDate dataAtual = LocalDate.now();
			if (dataAtual.isAfter(emprestimo.getDataPrevista())) {
				multa = FormatadorDeNumeros.formatarBigDecimalComoMoeda(new BigDecimal(15.0d));
			}
		} else {
			limparCampos();
		}
	}

	public void realizarDevolucao() {
		setarEmprestimo();
		emprestimo.setDataDevolucao(LocalDate.now());

		emprestimoBO.atualizar(emprestimo);

		listaLivrosEmprestado = livroBO.listarLivrosEmprestados();

		limparCampos();

		MensagemUtil.addMensagemInformativa("Sucesso - ", "Devolução realizada com sucesso!");
	}

	private void setarEmprestimo() {
		Livro livroSelecionado = getLivroSelecionado();
		Emprestimo emprestimoDoLivroSelecionado = getEmprestimoDoLivroSelecionado(livroSelecionado);
		emprestimo = emprestimoDoLivroSelecionado;
	}

	private Livro getLivroSelecionado() {
		for (Livro livro : getListaLivrosEmprestado()) {
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
		multa = FormatadorDeNumeros.formatarBigDecimalComoMoeda(new BigDecimal(0.0d));
	}

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public List<Livro> getListaLivrosEmprestado() {
		if (listaLivrosEmprestado == null) {
			listaLivrosEmprestado = livroBO.listarLivrosEmprestados();
		}
		return listaLivrosEmprestado;
	}

	public void setListaLivrosEmprestado(List<Livro> listaLivrosEmprestados) {
		this.listaLivrosEmprestado = listaLivrosEmprestados;
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

	public String getMulta() {
		return multa;
	}

	public void setMulta(String multa) {
		this.multa = multa;
	}
}

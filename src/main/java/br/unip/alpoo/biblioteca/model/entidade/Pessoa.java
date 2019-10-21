package br.unip.alpoo.biblioteca.model.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
/**
 * 
 * @author Luan
 *O mapeamento da herança é descrito através da anotação  @inheritance, 
 *que define a estratégia usada no mapeamento
 *
 *** SINGLE_TABLE - é mais comum, sendo a opção default.Nessa estratégia
 *todas as entidades da hierarquia são persistidas em uma única tabela, que 
 *contém dos os campos necessários. 
 *
 * ** TABLE-PER-CLASS - cada classe concreta e mapeada para uma tabela especifica
 *
 * ** JOINED - uma associação de tabelas é usada para persistencia de cada classe do modelo 
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa implements GenericoEntidade{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String sexo;
	private String cpf;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}

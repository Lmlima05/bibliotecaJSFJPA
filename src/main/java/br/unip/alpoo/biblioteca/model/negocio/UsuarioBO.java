package br.unip.alpoo.biblioteca.model.negocio;

import java.util.List;

import br.unip.alpoo.biblioteca.model.entidade.Usuario;
import br.unip.alpoo.biblioteca.model.persistencia.UsuarioDAO;

public class UsuarioBO extends GenericoBO<Usuario> {
	
	UsuarioDAO usuarioDAO;
	public UsuarioBO() {
		super();
		genericoDAO = new UsuarioDAO(Usuario.class, entityManager);
	}

	@Override
	public void inserir(Usuario entidade) {
		genericoDAO.inserir(entidade);
	}

	@Override
	public void remover(Usuario entidade) {
		genericoDAO.remover(entidade);
	}

	@Override
	public void atualizar(Usuario entidade) {
		genericoDAO.atualizar(entidade);
	}

	@Override
	public List<Usuario> listarTodos() {
		return genericoDAO.listarTodos();
	}
	@Override
	public Usuario pesquisarPorID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario pesquisarUsuario(Usuario usuario) {
		return ((UsuarioDAO) genericoDAO).pesquisarUsuario(usuario);
	}
	public boolean existeUsuarioCadastrado() {
		boolean existeUsuario  = ((UsuarioDAO) genericoDAO).existeUsuarioCadastrado();
		return existeUsuario;
	}
}

package br.unip.alpoo.biblioteca.model.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.unip.alpoo.biblioteca.model.entidade.Usuario;

public class UsuarioDAO extends GenericoDAO<Usuario> {


	
	public UsuarioDAO(Class<Usuario> classeDaEntidade , EntityManager entityManager) {
		super(classeDaEntidade, entityManager);

	}
	

	public boolean existeUsuarioCadastrado() {
		List<Usuario> listaDeUsuarios = listarTodos();
		
		if(listaDeUsuarios != null && listaDeUsuarios.size() > 0){
			return true;
		}
		
		return false;
	}


	public Usuario pesquisarUsuario(Usuario usuario) {
		Usuario usuarioEncontrado = null;
		
		Query query = entityManager.createQuery("select u from Usuario u where u.login = :loginParam and u.senha = :senhaParam")
				.setParameter("loginParam", usuario.getLogin())
				.setParameter("senhaParam", usuario.getSenha());

		try{
			usuarioEncontrado = (Usuario)query.getSingleResult();
		}catch(NoResultException e){
			// n�o faz nada, se n�o achar o usu�rio deixa retornar null
		}

		return usuarioEncontrado;
	}

}
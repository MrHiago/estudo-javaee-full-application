package br.com.casadocodigo.loja.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.models.Usuario;

public class UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Usuario usuario) {
		this.entityManager.persist(usuario);
	}
	
}

package br.com.helpte.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

import br.com.helpte.dao.UsuarioDao;
import br.com.helpte.entity.Usuario;

public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer> implements UsuarioDao {

	public UsuarioDaoImpl(EntityManager em) {
		super(em);
	}

	public List<Usuario> listar() {
		TypedQuery<Usuario> query = 
				em.createQuery("FROM Usuario", Usuario.class);
		return query.getResultList();
	}
}

package br.com.helpte.dao;

import java.util.List;

import br.com.helpte.entity.Usuario;

public interface UsuarioDao extends GenericDao<Usuario, Integer> {
	List<Usuario> listar();
}

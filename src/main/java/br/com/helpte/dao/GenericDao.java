package br.com.helpte.dao;

import java.util.List;

import br.com.helpte.exception.CommitException;
import br.com.helpte.exception.EntidadeNaoEcontradaException;

public interface GenericDao<E,K> {

	void salvar(E entidade);
	void deletar(K id) throws EntidadeNaoEcontradaException;
	E buscar(K id) throws EntidadeNaoEcontradaException;
	void commit() throws CommitException;
	
	List<E> listar();
	
}
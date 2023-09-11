package br.com.helpte.dao;

import java.util.List;

import br.com.helpte.entity.Configuracao;

public interface ConfiguracaoDao extends GenericDao<Configuracao, Integer> {
	List<Configuracao> listar();
}

package br.com.helpte.dao.impl;

import jakarta.persistence.EntityManager;

import java.util.List;

import jakarta.persistence.TypedQuery;

import br.com.helpte.dao.ConfiguracaoDao;
import br.com.helpte.entity.Configuracao;

public class ConfiguracaoDaoImpl extends GenericDaoImpl<Configuracao, Integer> implements ConfiguracaoDao {

	public ConfiguracaoDaoImpl(EntityManager em) {
		super(em);
	}

	public List<Configuracao> listar() {
		TypedQuery<Configuracao> query = 
				em.createQuery("from Configuracao", Configuracao.class);
		return query.getResultList();
	}
}

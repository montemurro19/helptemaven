package br.com.helpte.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

import br.com.helpte.dao.HistoricoDao;
import br.com.helpte.entity.Historico;

public class HistoricoDaoImpl extends GenericDaoImpl<Historico, Integer> implements HistoricoDao {

	public HistoricoDaoImpl(EntityManager em) {
		super(em);
	}

	public List<Historico> listar() {
		TypedQuery<Historico> query = 
				em.createQuery("from Historico", Historico.class);
		return query.getResultList();
	}
	
}

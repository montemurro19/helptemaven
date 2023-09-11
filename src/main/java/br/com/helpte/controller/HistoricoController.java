package br.com.helpte.controller;


import java.util.List;

import jakarta.persistence.EntityManager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.helpte.dao.HistoricoDao;
import br.com.helpte.dao.impl.HistoricoDaoImpl;
import br.com.helpte.entity.Historico;
import br.com.helpte.exception.CommitException;
import br.com.helpte.sigleton.EntityManagerFactorySingleton;
import br.com.helpte.exception.EntidadeNaoEcontradaException;

@RestController
public class HistoricoController {

	private EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
	
	HistoricoDao dao = new HistoricoDaoImpl(em);
	
	private HistoricoDao historicoDao = new HistoricoDaoImpl(em);	

	@GetMapping("/historico")
	ResponseEntity<List<Historico>> all() {
		List<Historico> historicoList = historicoDao.listar();
		return ResponseEntity.ok(historicoList);
	}

	@PostMapping("/historico")
	public ResponseEntity<Historico> newHistorico(@RequestBody Historico newHistorico) {
		try {
			dao.salvar(newHistorico);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok(newHistorico);
	}

	@GetMapping("/historico/{id}")
	public ResponseEntity<Historico> one(@PathVariable Integer id) {
		
		Historico historico = null;
		try {
			historico = dao.buscar(id);
		} catch (EntidadeNaoEcontradaException e) {
			
			e.printStackTrace();
		}
		if (historico == null) {
			ResponseEntity.notFound();
		}
		return ResponseEntity.ok(historico);
	}

	@PutMapping("/historico/{id}")
	public ResponseEntity<Historico> replaceHistorico(@RequestBody Historico newHistorico, @PathVariable Integer id) {
		
		try {
			dao.salvar(newHistorico);
			dao.commit();
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}
		return ResponseEntity.ok(newHistorico);
	}

	@DeleteMapping("/historico/{id}")
	public ResponseEntity<Historico> deleteHistorico(@PathVariable Integer id) {
		try {
			dao.deletar(id);
			dao.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return ResponseEntity.ok().build();
	}
}

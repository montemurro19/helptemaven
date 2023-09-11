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

import br.com.helpte.dao.ConfiguracaoDao;
import br.com.helpte.dao.impl.ConfiguracaoDaoImpl;
import br.com.helpte.entity.Configuracao;
import br.com.helpte.exception.CommitException;
import br.com.helpte.sigleton.EntityManagerFactorySingleton;
import br.com.helpte.exception.EntidadeNaoEcontradaException;

@RestController
public class ConfiguracaoController {

	private EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
	
	ConfiguracaoDao dao = new ConfiguracaoDaoImpl(em);
	
	private ConfiguracaoDao configuracaoDao = new ConfiguracaoDaoImpl(em);	

	@GetMapping("/configuracao")
	ResponseEntity<List<Configuracao>> all() {
		List<Configuracao> configuracaoList = configuracaoDao.listar();
		return ResponseEntity.ok(configuracaoList);
	}

	@PostMapping("/configuracao")
	public ResponseEntity<Configuracao> newConfiguracao(@RequestBody Configuracao newConfiguracao) {
		try {
			dao.salvar(newConfiguracao);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok(newConfiguracao);
	}

	@GetMapping("/configuracao/{id}")
	public ResponseEntity<Configuracao> one(@PathVariable Integer id) {
		
		Configuracao configuracao = null;
		try {
			configuracao = dao.buscar(id);
		} catch (EntidadeNaoEcontradaException e) {
			
			e.printStackTrace();
		}
		if (configuracao == null) {
			ResponseEntity.notFound();
		}
		return ResponseEntity.ok(configuracao);
	}

	@PutMapping("/configuracao/{id}")
	public ResponseEntity<Configuracao> replaceConfiguracao(@RequestBody Configuracao newConfiguracao, @PathVariable Integer id) {
		
		try {
			dao.salvar(newConfiguracao);
			dao.commit();
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}
		return ResponseEntity.ok(newConfiguracao);
	}

	@DeleteMapping("/configuracao/{id}")
	public ResponseEntity<Configuracao> deleteConfiguracao(@PathVariable Integer id) {
		try {
			dao.deletar(id);
			dao.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return ResponseEntity.ok().build();
	}
}

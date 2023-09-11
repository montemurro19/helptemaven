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

import br.com.helpte.dao.UsuarioDao;
import br.com.helpte.dao.impl.UsuarioDaoImpl;
import br.com.helpte.entity.Usuario;
import br.com.helpte.exception.CommitException;
import br.com.helpte.sigleton.EntityManagerFactorySingleton;
import br.com.helpte.exception.EntidadeNaoEcontradaException;

@RestController
public class UsuarioController {

	private EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
	
	UsuarioDao dao = new UsuarioDaoImpl(em);
	
	private UsuarioDao usuarioDao = new UsuarioDaoImpl(em);	

	@GetMapping("/usuario")
	ResponseEntity<List<Usuario>> all() {
		List<Usuario> usuarioList = usuarioDao.listar();
		return ResponseEntity.ok(usuarioList);
	}

	@PostMapping("/usuario")
	public ResponseEntity<Usuario> newUsuario(@RequestBody Usuario newUsuario) {
		try {
			dao.salvar(newUsuario);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok(newUsuario);
	}

	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> one(@PathVariable Integer id) {
		
		Usuario usuario = null;
		try {
			usuario = dao.buscar(id);
		} catch (EntidadeNaoEcontradaException e) {
			
			e.printStackTrace();
		}
		if (usuario == null) {
			ResponseEntity.notFound();
		}
		return ResponseEntity.ok(usuario);
	}

	@PutMapping("/usuario/{id}")
	public ResponseEntity<Usuario> replaceUsuario(@RequestBody Usuario newUsuario, @PathVariable Integer id) {
		
		try {
			dao.salvar(newUsuario);
			dao.commit();
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}
		return ResponseEntity.ok(newUsuario);
	}

	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<Usuario> deleteUsuario(@PathVariable Integer id) {
		try {
			dao.deletar(id);
			dao.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return ResponseEntity.ok().build();
	}
}

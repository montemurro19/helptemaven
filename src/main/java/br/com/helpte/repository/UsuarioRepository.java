package br.com.helpte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.helpte.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

}
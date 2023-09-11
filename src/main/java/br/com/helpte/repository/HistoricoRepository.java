package br.com.helpte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.helpte.entity.Historico;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico,Integer>{

}
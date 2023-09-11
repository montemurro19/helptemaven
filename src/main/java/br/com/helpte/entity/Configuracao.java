package br.com.helpte.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="HTE_CONFIGURACAO")
@SequenceGenerator(sequenceName = "SQ_HTE_CONFIGURACAO", name="configuracao", allocationSize = 1)
public class Configuracao {

	@Id
	@Column(name="ID_CONFIGURACAO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "configuracao")
	private Integer codigo;
	
	@Column(name="LINGUA", length = 50)
	private String lingua;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_USUARIO", nullable = false)
	private Usuario usuario;

	public Configuracao() {}
	
	public Configuracao(String lingua, Usuario usuario) {
		super();
		this.lingua = lingua;
		this.usuario = usuario;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getLingua() {
		return lingua;
	}

	public void setLingua(String lingua) {
		this.lingua = lingua;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}

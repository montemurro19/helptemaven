package br.com.helpte.entity;

import java.util.Calendar;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="HTE_HISTORICO")
@SequenceGenerator(sequenceName = "SQ_HTE_HISTORICO", name="historico", allocationSize = 1)
public class Historico {

	@Id
	@Column(name="ID_HISTORICO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historico")
	private Integer codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATAHORA")
	private Calendar dataHora;
	
	@Column(name="FRASE", length = 300)
	private String frase;
	
	@Column(name="TRADUCAO", length = 300)
	private String traducao;
	
	@ManyToOne
	@JoinColumn(name="ID_USUARIO", nullable = false)
	private Usuario usuario;

	public Historico () {}
	
	public Historico(Calendar dataHora, String frase, String traducao, Usuario usuario) {
		super();
		this.dataHora = dataHora;
		this.frase = frase;
		this.traducao = traducao;
		this.usuario = usuario;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}

	public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}

	public String getTraducao() {
		return traducao;
	}

	public void setTraducao(String traducao) {
		this.traducao = traducao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}

package br.com.helpte.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="HTE_USUARIO")
@SequenceGenerator(sequenceName = "SQ_HTE_USUARIO", name="usuario", allocationSize = 1)
public class Usuario {

	@Id
	@Column(name="ID_USUARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
	private Integer codigo;
	
	@Column(name="NOME", nullable = false, length = 100)
	private String nome;
	
	@Column(name="IDADE", nullable = false, scale = 3)
	private Integer idade;
	
	@Column(name="USUARIO", nullable = false, length = 100)
	private String usuario;
	
	@Column(name="SENHA", nullable = false, length = 50)
	private String senha;

	public Usuario () {}
	
	public Usuario(String nome, Integer idade, String usuario, String senha) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.usuario = usuario;
		this.senha = senha;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}

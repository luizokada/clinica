package entity;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "Pacientes", schema = "clinica", catalog = "")
public class Paciente {
	@Column(name = "codigo")
	private int codigo;
	@Column(name = "nome")
	private String nome;
	@Column(name = "endereco")
	private String endereco;
	@Column(name = "dataDeNascimento")
	private String dataDeNascimento;
	@Column(name = "observacao")
	private String observacoes;
	
	public Paciente() {
		super();
	}
	public Paciente(int codigo, String nome, String endereco, String observacoes, String data) {
		super();
		this.codigo=codigo;
		this.nome = nome;
		this.observacoes = observacoes;
		this.endereco = endereco;
		this.dataDeNascimento = data;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNasciemento) {
		this.dataDeNascimento = dataDeNasciemento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	

}

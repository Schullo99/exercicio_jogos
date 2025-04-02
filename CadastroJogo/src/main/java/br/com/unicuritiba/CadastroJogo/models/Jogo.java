package br.com.unicuritiba.CadastroJogo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tabela_jogo")
public class Jogo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private String data_lancamento;
	private String desenvolvedora;
	private String classificacao;
	private Double armazenamento;
	private String Single_multi;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getData_lancamento() {
		return data_lancamento;
	}
	public void setData_lancamento(String data_lancamento) {
		this.data_lancamento = data_lancamento;
	}
	public String getDesenvolvedora() {
		return desenvolvedora;
	}
	public void setDesenvolvedora(String desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public Double getArmazenamento() {
		return armazenamento;
	}
	public void setArmazenamento(Double armazenamento) {
		this.armazenamento = armazenamento;
	}
	public String getSingle_multi() {
		return Single_multi;
	}
	public void setSingle_multi(String single_multi) {
		Single_multi = single_multi;
	}

}

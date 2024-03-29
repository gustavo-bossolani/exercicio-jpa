package br.com.financas.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String titular;
	private int numero;
	private int agencia;

	// FetchType.EAGER define ao hibernate que as movimentações serão buscadas junto as contas
	@OneToMany(mappedBy="conta", fetch = FetchType.EAGER)
	private List<Movimentacao> movimentacoes;

//	@OneToOne
//	@JoinColumn(unique=true)
//	private Cliente cliente;
	
	@Deprecated
	public Conta() {}

	public Conta(String titular, int numero, int agencia) {
		this.titular = titular;
		this.numero = numero;
		this.agencia = agencia;
	}

//	public Cliente getCliente() {
//		return cliente;
//	}
//	
//	public void setCliente(Cliente cliente) {
//		this.cliente = cliente;
//	}
	
	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}


	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
}

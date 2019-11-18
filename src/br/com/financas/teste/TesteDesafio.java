package br.com.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.util.JPAUtil;

public class TesteDesafio {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		Conta conta = em.find(Conta.class, 2);

		List<Movimentacao> movimentacoes = conta.getMovimentacoes();

		em.close();

		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Movimentação: " + movimentacao.getDescricao());
		}


	}

}

package br.com.financas.teste;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        Movimentacao movimentacao = em.find(Movimentacao.class, 1);
        Conta conta = movimentacao.getConta();
        
        System.out.println(conta.getTitular());
        System.out.println(conta.getMovimentacoes());

	}

}

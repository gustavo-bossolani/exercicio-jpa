package br.com.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

public class TesteTodasMovimentacoesDasContas {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String jqpl = "select distinct c from Conta c left join fetch c.movimentacoes";
		Query query = em.createQuery(jqpl);
		
		List<Conta> contas = query.getResultList();
		
		for (Conta conta : contas) {
			System.out.println();
			System.out.println("Titular:" + conta.getTitular());
			System.out.println("Movimentações:");
			System.out.println(conta.getMovimentacoes());
		}
		
	}

}

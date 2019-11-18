package br.com.financas.teste;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.modelo.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		
		
		Conta conta = new Conta();
		conta.setTitular("Gustavo Bossolani");
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		
		String jpql = "select m from Movimentacao m where m.conta.titular = :pTitular "
				+ "and m.tipo = :pTipo "
				+ "order by m.valor desc";
		Query query = manager.createQuery(jpql);
		query.setParameter("pTitular", conta.getTitular());
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Movimentacao> resultado = query.getResultList();
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		for (Movimentacao movimentacao : resultado) {
			System.out.println("---------------------------");
			System.out.println(movimentacao.getConta().getTitular());
			System.out.println(movimentacao.getDescricao());
			System.out.println(movimentacao.getValor());
			System.out.println(movimentacao.getTipo());
			System.out.println(format.format(movimentacao.getData().getTime()));
		}
		
		manager.getTransaction().commit();
		manager.close();
	}

}

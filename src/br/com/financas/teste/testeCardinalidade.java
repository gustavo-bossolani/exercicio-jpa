package br.com.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.financas.modelo.Categoria;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.util.JPAUtil;

public class testeCardinalidade {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();


		Categoria categoria = new Categoria();
		categoria.setId(1);

		String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";

		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);

		List<Movimentacao> resultados = query.getResultList();
		for (Movimentacao movimentacao : resultados) {
			System.out.println("___________________________________");
			System.out.println(movimentacao.getDescricao());
			System.out.println(movimentacao.getConta().getTitular());
			System.out.println(movimentacao.getValor());
		}
		
		em.getTransaction().commit();
		em.close();
	}
}

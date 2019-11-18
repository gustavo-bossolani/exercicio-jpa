package br.com.financas.teste;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

public class Teste {

	public static void main(String[] args) {
		
		Conta conta1  = new Conta("Klebão", 234567, 35);
		Conta conta2  = new Conta("Gustavo Bossolani", 4556, 231);
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta1);
		em.persist(conta2);
		em.getTransaction().commit();
		
		
		em.close();
	}

}

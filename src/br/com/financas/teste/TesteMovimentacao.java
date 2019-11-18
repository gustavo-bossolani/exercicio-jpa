package br.com.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Categoria;
import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.modelo.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class TesteMovimentacao {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Categoria cat1 = new Categoria("Estudo");
		Categoria cat2 = new Categoria("Hardware");
		Categoria cat3 = new Categoria();
		cat3.setId(1);

		manager.persist(cat1);
		manager.persist(cat2);
		
		Movimentacao mov1 = new Movimentacao();
		
		mov1.setCategoria(cat1);
		mov1.setCategoria(cat2);
		mov1.setCategoria(cat3);
		mov1.setData(Calendar.getInstance());
		mov1.setDescricao("Compra - Macbook Air PRO");
		mov1.setTipo(TipoMovimentacao.SAIDA);
		mov1.setConta(manager.find(Conta.class, 4));
		mov1.setValor(new BigDecimal("4500.00"));
	
		Movimentacao mov2 = new Movimentacao();
		
		mov2.setCategoria(cat3);
		mov2.setData(Calendar.getInstance());
		mov2.setDescricao("Viagem Canadá");
		mov2.setTipo(TipoMovimentacao.SAIDA);
		mov2.setConta(manager.find(Conta.class, 4));
		mov2.setValor(new BigDecimal("8000.00"));
		
		manager.persist(mov1);
		manager.persist(mov2);
		
		manager.getTransaction().commit();
		manager.close();
	}
}

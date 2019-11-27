package br.com.financas.util;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Categoria;
import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.modelo.TipoMovimentacao;

public class PopulaMovimentacao {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		Conta conta1  = manager.find(Conta.class, 1);
		Conta conta2  = manager.find(Conta.class, 2);
		
		Categoria contas = new Categoria("Contas");
		Categoria viagem = new Categoria("Viagem");
		Categoria mensalidade = new Categoria("Mensalidade");
		Categoria negocios = new Categoria("Negócios");
		Categoria restaurante = new Categoria("Restaurante");
		
		manager.persist(contas);
		manager.persist(viagem);
		manager.persist(mensalidade);
		manager.persist(negocios);
		manager.persist(restaurante);

		
		// Movimentacoes da conta1
		Movimentacao movimentacao1 = new Movimentacao();
		Movimentacao movimentacao2 = new Movimentacao();
		Movimentacao movimentacao3 = new Movimentacao();

		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setDescricao("Conta de luz - ABRIL/2019");
		movimentacao1.setValor(new BigDecimal("135"));
		movimentacao1.setTipo(TipoMovimentacao.SAIDA);
		movimentacao1.setConta(conta1);
		movimentacao1.setCategoria(contas);
		
		manager.persist(movimentacao1);

		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setDescricao("Almoco no Restaurante - AGOSTO/2012");
		movimentacao2.setValor(new BigDecimal("175.80"));
		movimentacao2.setTipo(TipoMovimentacao.SAIDA);
		movimentacao2.setConta(conta1);
		movimentacao2.setCategoria(restaurante);
		movimentacao2.setCategoria(negocios);

		manager.persist(movimentacao2);

		movimentacao3.setData(Calendar.getInstance());
		movimentacao3.setDescricao("Aluguel - MAIO/2012");
		movimentacao3.setValor(new BigDecimal("680.00"));
		movimentacao3.setTipo(TipoMovimentacao.ENTRADA);
		movimentacao3.setConta(conta1);
		movimentacao3.setCategoria(mensalidade);
		
		
		// Movimentacoes da conta2
		Movimentacao movimentacao4 = new Movimentacao();
		Movimentacao movimentacao5 = new Movimentacao();
		Movimentacao movimentacao6 = new Movimentacao();

		movimentacao4.setData(Calendar.getInstance());
		movimentacao4.setDescricao("Viagem - ABRIL/2020");
		movimentacao4.setValor(new BigDecimal("135"));
		movimentacao4.setTipo(TipoMovimentacao.SAIDA);
		movimentacao4.setConta(conta2);
		movimentacao4.setCategoria(viagem);
		movimentacao4.setCategoria(negocios);
		
		
		manager.persist(movimentacao4);

		movimentacao5.setData(Calendar.getInstance());
		movimentacao5.setDescricao("Almoco no Restaurante - AGOSTO/2012");
		movimentacao5.setValor(new BigDecimal("175.80"));
		movimentacao5.setTipo(TipoMovimentacao.SAIDA);
		movimentacao5.setConta(conta2);
		movimentacao5.setCategoria(restaurante);
		movimentacao5.setCategoria(negocios);

		manager.persist(movimentacao5);

		movimentacao6.setData(Calendar.getInstance());
		movimentacao6.setDescricao("Aluguel - MAIO/2012");
		movimentacao6.setValor(new BigDecimal("680.00"));
		movimentacao6.setTipo(TipoMovimentacao.ENTRADA);
		movimentacao6.setConta(conta2);
		movimentacao6.setCategoria(mensalidade);
		
		
		manager.persist(movimentacao6);

		manager.getTransaction().commit();

		manager.close();

	}

}
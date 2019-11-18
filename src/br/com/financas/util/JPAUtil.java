package br.com.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {


	private static EntityManagerFactory entityManager = 
			Persistence.createEntityManagerFactory("financasmysql");

	public EntityManager getEntityManager() {
		return entityManager.createEntityManager();
	}
}

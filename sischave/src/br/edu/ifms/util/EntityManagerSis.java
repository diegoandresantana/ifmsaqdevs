package br.edu.ifms.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

 
public class EntityManagerSis {
	 

		private EntityManagerFactory factory;

		public EntityManagerSis() {
			this.factory = Persistence.createEntityManagerFactory("sischavePU");
		}

		 
		public EntityManager create() {
			return factory.createEntityManager();
		}

		public void close( EntityManager manager) {
			manager.close();
		}
		
	 
}

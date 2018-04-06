package br.edu.ifms.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

import br.edu.ifms.entity.Chave;

public class ChaveDAO  implements Serializable {

		private static final long serialVersionUID = 1L;

		@Inject
		private EntityManager manager;
		
		@Transactional
		public Chave salvar(Chave chave) {
			 
				chave = this.manager.merge(chave);
				return chave;
			 
		}
		
	 
	}
}

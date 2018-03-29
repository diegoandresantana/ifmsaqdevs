package residencecare.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import residencecare.dao.inter.ChuvaInterDAO;
import residencecare.entity.Chuva;
@Service
@Transactional
@EntityScan("residencecare.dao.impl")
public   class ChuvaDAO extends SimpleJpaRepository<Chuva, Long> 
implements ChuvaInterDAO<Chuva, Long>{
	 private final EntityManager entityManager;
	public ChuvaDAO(JpaEntityInformation<Chuva, Long> entityInformation, EntityManager entityManager){
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }
	 
    @Transactional
    @Override
	public Chuva getLastObject(){
		Chuva c =  new Chuva();
        return c;
	}
}

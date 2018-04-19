package residencecare.dao.inter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import residencecare.entity.Umidade;

public interface UmidadeInterDAO extends JpaRepository<Umidade, Long>{
	
	@Query(value = "select * from Umidade c order by c.id_umidade desc limit 1", nativeQuery = true)
	public Umidade lastItem();

}

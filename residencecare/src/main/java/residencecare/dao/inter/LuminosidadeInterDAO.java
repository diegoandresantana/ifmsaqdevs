package residencecare.dao.inter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import residencecare.entity.Luminosidade;

public interface LuminosidadeInterDAO extends JpaRepository<Luminosidade, Long>{
	
	@Query(value = "select * from Luminosidade c order by c.id_luminosidade desc limit 1", nativeQuery = true)
	public Luminosidade lastItem();

}

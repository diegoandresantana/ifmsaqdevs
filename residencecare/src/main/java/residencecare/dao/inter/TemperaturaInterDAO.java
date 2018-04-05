package residencecare.dao.inter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import residencecare.entity.Chuva;
import residencecare.entity.Temperatura;

public interface TemperaturaInterDAO extends JpaRepository<Temperatura, Long>{

	@Query(value = "select * from Temperatura t order by t.id_temperatura desc limit 1", nativeQuery = true)
	public Temperatura lastItem();
}

package residencecare.dao.inter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import residencecare.entity.Chuva;
 
public interface ChuvaInterDAO 
extends JpaRepository<Chuva,Long >, ChuvaInterCustomDAO {
	@Query(value = "select * from Chuva c order by c.id_Chuva desc limit 1", nativeQuery = true)
    public Chuva lastItem();
	
	//;@Query("select c from Customer c where c.email = :email")
    //Stream<Customer> findByEmailReturnStream(@Param("email") String email);
}

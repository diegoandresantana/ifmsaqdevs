package residencecare.dao.inter;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
@NoRepositoryBean
public interface ChuvaInterDAO<Chuva,Long extends Serializable> extends JpaRepository<Chuva,Long >{
	public Chuva getLastObject();
}

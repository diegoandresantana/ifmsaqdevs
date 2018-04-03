package developergirls.dao.inter;

import org.springframework.data.jpa.repository.JpaRepository;

import developergirls.entity.Categoria;
 
public interface CategoriaInterDAO 
extends JpaRepository<Categoria,Long >, CategoriaInterCustomDAO {
	 
}

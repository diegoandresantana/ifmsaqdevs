package developergirls.dao.inter;

import org.springframework.data.jpa.repository.JpaRepository;

import developergirls.entity.Categoria;
 
public interface InterCategoriaDAO 
extends JpaRepository<Categoria,Long > {
	 
}

package developergirls.dao.inter;

import org.springframework.data.jpa.repository.JpaRepository;

import developergirls.entity.Noticia;
 
public interface InterNoticiaDAO 
extends JpaRepository<Noticia,Long >{
	 
}

package developergirls.dao.inter;

import org.springframework.data.jpa.repository.JpaRepository;

import developergirls.entity.Noticia;
 
public interface NoticiaInterDAO 
extends JpaRepository<Noticia,Long >, NoticiaInterCustomDAO {
	 
}

package developergirls.dao.inter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import developergirls.entity.Usuario;
 
public interface UsuarioInterDAO 
extends JpaRepository<Usuario,Long > {
	@Query("select u from Usuario u where u.login = :login")
	public Usuario getByLogin(@Param("login") String login);
	 
}

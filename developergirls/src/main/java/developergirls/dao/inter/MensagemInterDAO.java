package developergirls.dao.inter;

import org.springframework.data.jpa.repository.JpaRepository;

import developergirls.entity.Mensagem;
 
public interface MensagemInterDAO 
extends JpaRepository<Mensagem,Long >{
	 
}

package residencecare.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Luminosidade {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLuminosidade;
	private Double dado;
	public Long getIdLuminosidade() {
		return idLuminosidade;
	}
	public void setIdLuminosidade(Long idLuminosidade) {
		this.idLuminosidade = idLuminosidade;
	}
	public Double getDado() {
		return dado;
	}
	public void setDado(Double dado) {
		this.dado = dado;
	}
	
	
}

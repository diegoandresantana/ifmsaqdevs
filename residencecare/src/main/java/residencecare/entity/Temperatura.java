package residencecare.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Temperatura {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTemperatura;
	private Double dado;
	public Long getIdTemperatura() {
		return idTemperatura;
	}
	public void setIdTemperatura(Long idTemperatura) {
		this.idTemperatura = idTemperatura;
	}
	public Double getDado() {
		return dado;
	}
	public void setDado(Double dado) {
		this.dado = dado;
	}
	
	
}

package residencecare.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chuva {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idChuva;
	private Double dado;
	public Long getIdChuva() {
		return idChuva;
	}
	public void setIdChuva(Long idChuva) {
		this.idChuva = idChuva;
	}
	public Double getDado() {
		return dado;
	}
	public void setDado(Double dado) {
		this.dado = dado;
	}
	
	
	
}

package residencecare.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Umidade {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUmidade;	
	private Double dado;
	
	public Long getIdUmidade() {
		return idUmidade;
	}
	public void setIdUmidade(Long idUmidade) {
		this.idUmidade = idUmidade;
	}
	public Double getDado() {
		return dado;
	}
	public void setDado(Double dado) {
		this.dado = dado;
	}
}

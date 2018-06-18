package residencecare.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Chuva  implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idChuva;
	private Double dado;
	 
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;
	@PrePersist
	void addDate() {
		setDataHora(this.dataHora = new Date());
	}
	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

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

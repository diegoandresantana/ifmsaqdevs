package residencecare.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ControleEstado implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idControleEstado;
	private Boolean porta1;
	private Boolean porta2;
	private Boolean porta3;
	private Boolean porta4;
	private Boolean porta5;
	private Boolean porta6;
	private Boolean porta7;
	private Boolean porta8;
	
	public Integer getIdControleEstado() {
		return idControleEstado;
	}
	public void setIdControleEstado(Integer idControleEstado) {
		this.idControleEstado = idControleEstado;
	}
	public Boolean getPorta1() {
		return porta1;
	}
	public void setPorta1(Boolean porta1) {
		this.porta1 = porta1;
	}
	public Boolean getPorta2() {
		return porta2;
	}
	public void setPorta2(Boolean porta2) {
		this.porta2 = porta2;
	}
	public Boolean getPorta3() {
		return porta3;
	}
	public void setPorta3(Boolean porta3) {
		this.porta3 = porta3;
	}
	public Boolean getPorta4() {
		return porta4;
	}
	public void setPorta4(Boolean porta4) {
		this.porta4 = porta4;
	}
	public Boolean getPorta5() {
		return porta5;
	}
	public void setPorta5(Boolean porta5) {
		this.porta5 = porta5;
	}
	public Boolean getPorta6() {
		return porta6;
	}
	public void setPorta6(Boolean porta6) {
		this.porta6 = porta6;
	}
	public Boolean getPorta7() {
		return porta7;
	}
	public void setPorta7(Boolean porta7) {
		this.porta7 = porta7;
	}
	public Boolean getPorta8() {
		return porta8;
	}
	public void setPorta8(Boolean porta8) {
		this.porta8 = porta8;
	}
	  
}
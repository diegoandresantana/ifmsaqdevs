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
	private boolean porta1;
	private boolean porta2;
	private boolean porta3;
	private boolean porta4;
	private boolean porta5;
	private boolean porta6;
	private boolean porta7;
	private boolean porta8;
	private boolean prevencaoAtiva;
	public boolean isPrevencaoAtiva() {
		return prevencaoAtiva;
	}
	public void setPrevencaoAtiva(boolean prevencaoAtiva) {
		this.prevencaoAtiva = prevencaoAtiva;
	}
	public Integer getIdControleEstado() {
		return idControleEstado;
	}
	public void setIdControleEstado(Integer idControleEstado) {
		this.idControleEstado = idControleEstado;
	}
	public boolean isPorta1() {
		return porta1;
	}
	public void setPorta1(boolean porta1) {
		this.porta1 = porta1;
	}
	public boolean isPorta2() {
		return porta2;
	}
	public void setPorta2(boolean porta2) {
		this.porta2 = porta2;
	}
	public boolean isPorta3() {
		return porta3;
	}
	public void setPorta3(boolean porta3) {
		this.porta3 = porta3;
	}
	public boolean isPorta4() {
		return porta4;
	}
	public void setPorta4(boolean porta4) {
		this.porta4 = porta4;
	}
	public boolean isPorta5() {
		return porta5;
	}
	public void setPorta5(boolean porta5) {
		this.porta5 = porta5;
	}
	public boolean isPorta6() {
		return porta6;
	}
	public void setPorta6(boolean porta6) {
		this.porta6 = porta6;
	}
	public boolean isPorta7() {
		return porta7;
	}
	public void setPorta7(boolean porta7) {
		this.porta7 = porta7;
	}
	public boolean isPorta8() {
		return porta8;
	}
	public void setPorta8(boolean porta8) {
		this.porta8 = porta8;
	}
   
}
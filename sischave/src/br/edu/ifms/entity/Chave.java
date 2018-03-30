package br.edu.ifms.entity;

public class Chave {
	private Integer idChave;
	private String descricao;
	
	
	public Integer getIdChave() {
		return idChave;
	}
	public void setIdChave(Integer idChave) {
		this.idChave = idChave;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idChave == null) ? 0 : idChave.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chave other = (Chave) obj;
		if (idChave == null) {
			if (other.idChave != null)
				return false;
		} else if (!idChave.equals(other.idChave))
			return false;
		return true;
	}
	
	
	
	
}

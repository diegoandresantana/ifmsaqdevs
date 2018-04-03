package developergirls.entity;

import java.util.List;

import javax.persistence.Entity;
@Entity
public class Categoria {
	private Integer idCategoria;
	private String nomeCategoria;
	private List<Noticia> listaNoticia;
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public List<Noticia> getListaNoticia() {
		return listaNoticia;
	}
	public void setListaNoticia(List<Noticia> listaNoticia) {
		this.listaNoticia = listaNoticia;
	}
	
	
}

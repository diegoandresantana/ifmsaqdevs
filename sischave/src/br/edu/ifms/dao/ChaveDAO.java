package br.edu.ifms.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifms.entity.Chave;

public class ChaveDAO  implements Serializable {
		 	
	 static List<Chave> lista=new ArrayList<Chave>();
	 static int incremento =1;
	 public int incluir(Chave c) {
		 c.setIdChave(incremento);
		 incremento++;
		 return 1;
	 }
	 public int deletar(Chave c) {
		 lista.remove(c);
		 return 1;
	 }
	 public int alterar(Chave c) {
		 lista.set(lista.indexOf(c), c);
		 return 1;
	 }
	 public List<Chave> listar() {
		 return lista;
	 }
	 
}

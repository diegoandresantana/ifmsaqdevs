package br.edu.ifms.view;

import org.zkoss.zhtml.Messagebox;

import br.edu.ifms.entity.Chave;
import br.edu.ifms.util.WindowCad;

public class ChaveCad extends WindowCad{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Chave chave=new Chave();
	public void init() {
		atualizarTela();
	}
	@Override
	public void inserir() {
	   
		Messagebox.show("Descri��o:"+chave.getDescricao());
		
	}

	@Override
	public void alterar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void limpar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pesquisar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sair() {
		// TODO Auto-generated method stub
		
	}

}

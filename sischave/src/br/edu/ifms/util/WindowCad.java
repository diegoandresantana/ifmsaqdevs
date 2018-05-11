package br.edu.ifms.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Window;

public abstract class WindowCad extends Window {
	/**
	 * Requisições
	 */
	protected Map request;

	/**
	 * Sessão
	 */
	protected HttpSession session;

	private AnnotateDataBinder binder = new AnnotateDataBinder(this);

	/**
	 * Componentes do Formulario
	 */
	private Map<String, HtmlBasedComponent> componentes = new HashMap<String, HtmlBasedComponent>();

	public WindowCad() {
		super();
		initView();
	}
 
	private void initView() {
		//request = ((ExecutionImpl) Executions.getCurrent()).getArg();
		//session = (HttpSession) Executions.getCurrent().getDesktop().getSession().getNativeSession();
	}
	public void atualizarTela() {
		binder.init(this, true);
		binder.loadAll();		
		
	}
	public abstract void inserir();

	public abstract void alterar();

	public abstract void deletar();

	public abstract void limpar();

	public abstract void pesquisar();

	public abstract  void sair();
}

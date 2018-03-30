package br.edu.ifms.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.http.ExecutionImpl;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Window;

public class WindowCad extends Window{
	/**
	 * Requisições
	 */
	protected Map request;

	/**
	 * Sessão
	 */
	protected HttpSession session;

	private AnnotateDataBinder binder = new AnnotateDataBinder((Desktop) this);

	/**
	 * Componentes do Formulario
	 */
	private Map<String, HtmlBasedComponent> componentes = new HashMap<String, HtmlBasedComponent>();
	 
	public WindowCad() {
			super();
		initView();
	}
	private void initView() {
		request = ((ExecutionImpl) Executions.getCurrent()).getArg();
		session = (HttpSession) Executions.getCurrent().getDesktop()
				.getSession().getNativeSession();
	}  
}

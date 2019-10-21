package br.unip.alpoo.biblioteca.listeners;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

import br.unip.alpoo.biblioteca.controller.bean.LoginBean;

/**
 * Responsável por manipular requisições de usuário, permitindo acesso ao
 * conteúdo da aplicação somente no caso do usuário já ter se autenticado.
 *
 * @author Luan
 */
public class ListenerAutenticacao implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String PAGINA_LOGIN = "/login.xhtml";

	@Override
	// metodo que será executado com logica especifica após que fase indicada
	// seja processada. Logo
	// quando terminar a executação do metodo a fase seguinte trnará o foco.
	public void afterPhase(PhaseEvent event) {

		FacesContext contexto = event.getFacesContext();
		String pagina = contexto.getViewRoot().getViewId();

		System.out.println(">>>>>>>>>>>>>>>>> ListenerAutenticacao.afterPhase() " + "para página de ID " + event.getFacesContext().getViewRoot().getViewId());

		if (!(pagina.lastIndexOf(PAGINA_LOGIN) > -1)) {
			HttpSession sessao = (HttpSession) contexto.getExternalContext().getSession(false);
			if (sessao == null) {
				NavigationHandler navHandler = contexto.getApplication().getNavigationHandler();
				navHandler.handleNavigation(contexto, null, "login?faces-redirect=true");
			}else {
				Object usuario = sessao.getAttribute(LoginBean.USUARIO_SESSAO);

				if (usuario == null) {
					NavigationHandler navHandler = contexto.getApplication().getNavigationHandler();
					navHandler.handleNavigation(contexto, null, "login?faces-redirect=true");
				}
			}
			
		}
	}

	@Override
	// metodo que será executado com logica especifica antes que fase indicada
	// seja processada
	public void beforePhase(PhaseEvent event) {
		if (event.getFacesContext().getViewRoot() != null) {
			System.out.println(">>>>>>>>>>>>>>>>> ListenerAutenticacao.beforePhase() " + "para página de ID " + event.getFacesContext().getViewRoot().getViewId());
		} else {
			System.out.println(">>>>>>>>>>>>>>>>> ListenerAutenticacao.beforePhase() " + "indicando view root ainda nula");
		}
	}

	@Override
	// o identificador da gase em que a requisição atual se encontra
	// metodo indicará qual e fase em que listener está interessado em analisar
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
}

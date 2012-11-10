package mx.upiicsa.titulacion.ctrls;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.pages.LoginPage;
import mx.upiicsa.titulacion.service.LoginService;
import mx.upiicsa.titulacion.util.JSFUtils;
import mx.upiicsa.titulacion.util.WConstants;

@Named("cLogin")
@RequestScoped
public class LoginCtrl implements Serializable {

	private static final long serialVersionUID = 5182361493231729891L;

	@Inject
	private LoginPage loginPage;
	@EJB
	private LoginService loginService;
	
	public String loginAction() {
		try {
			String usuario = loginService.login(loginPage.getLogin(), loginPage.getPassword());
			HttpSession session = (HttpSession) JSFUtils.getExternalContext()
					.getSession(true);
			session.setAttribute(WConstants.USUARIO_WEBOBJECT,
					usuario);
		} catch(TitulacionException e) {
			JSFUtils.messageGlobal(FacesMessage.SEVERITY_ERROR, e.getMessage());
			return null;
		}
		return "titulacionMain";
	}
}

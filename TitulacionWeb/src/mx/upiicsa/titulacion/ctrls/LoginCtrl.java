package mx.upiicsa.titulacion.ctrls;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.model.Usuario;
import mx.upiicsa.titulacion.pages.AlumnoPage;
import mx.upiicsa.titulacion.pages.CatalogoPage;
import mx.upiicsa.titulacion.pages.LoginPage;
import mx.upiicsa.titulacion.service.AlumnoService;
import mx.upiicsa.titulacion.service.CatalogoService;
import mx.upiicsa.titulacion.service.LoginService;
import mx.upiicsa.titulacion.util.JSFUtils;
import mx.upiicsa.titulacion.util.Messages;
import mx.upiicsa.titulacion.util.WConstants;
import mx.upiicsa.titulacion.web.menu.MenuSesion;

@Named("cLogin")
@RequestScoped
public class LoginCtrl implements Serializable {

	private static final long serialVersionUID = 5182361493231729891L;

	@Inject
	private LoginPage loginPage;
	@Inject
	private CatalogoPage catalogoPage;
	@Inject
	private AlumnoPage alumnoPage;
	@Inject
	private MenuSesion menuSesion;
	@EJB
	private CatalogoService catalogoService;
	@EJB
	private AlumnoService alumnoService;
	@EJB
	private LoginService loginService;

	public String logoutAction() {
		HttpSession session = (HttpSession) JSFUtils.getExternalContext()
				.getSession(true);
		session.removeAttribute(WConstants.USUARIO_WEBOBJECT);
		return "login";
	}

	public String loginAction() {
		try {
			Usuario usuario = loginService.login(loginPage.getLogin(), loginPage.getPassword());
			HttpSession session = (HttpSession) JSFUtils.getExternalContext()
					.getSession(true);
			session.setAttribute(WConstants.USUARIO_WEBOBJECT,
					usuario);
			initAlumnos();
		} catch(TitulacionException e) {
			JSFUtils.messageGlobal(FacesMessage.SEVERITY_ERROR, e.getMessage());
			return null;
		}
		return "alumnos";
	}
	
	private void initAlumnos() {
		try {
			catalogoPage.setCarreras(catalogoService.findAllCarrera());
			catalogoPage.setSexos(catalogoService.findAllSexo());
			alumnoPage.setAlumnos(alumnoService.findAllAlumno());
			menuSesion.setVistaActual("alumnos");
		} catch (TitulacionException e) {
			FacesMessage message = Messages.getMessage(
					e.getMessage(), null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
}

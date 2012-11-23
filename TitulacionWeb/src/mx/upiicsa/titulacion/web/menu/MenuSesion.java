package mx.upiicsa.titulacion.web.menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import mx.upiicsa.titulacion.model.Usuario;
import mx.upiicsa.titulacion.util.JSFUtils;
import mx.upiicsa.titulacion.util.WConstants;

@Named
@SessionScoped
public class MenuSesion implements Serializable {

	private static final long serialVersionUID = 476615910400197158L;

	@Inject
	private MainMenu mainMenu;
	
	private Usuario usuario;
	
	private String vistaActual;
	
	private List<MenuElemento> menu = new ArrayList<MenuElemento>();
	
	public boolean cambioUsuario() {
		HttpSession session = (HttpSession) JSFUtils.getExternalContext()
				.getSession(false);
		Usuario login = null;
		if (session != null) {
			login = (Usuario) session.getAttribute(WConstants.USUARIO_WEBOBJECT);
		}
		return login != null && !login.getNombre().equals(this.usuario.getNombre());
	}
	
	@PostConstruct
	public void init() {
		HttpSession session = (HttpSession) JSFUtils.getExternalContext()
				.getSession(false);
		if (session != null) {
			this.usuario = (Usuario) session.getAttribute(WConstants.USUARIO_WEBOBJECT);
		}
		this.menu.clear();
		for (MenuElemento elemento:mainMenu.getMenu()) {
			if (elemento.getPropiedades().get(this.usuario.getPerfil().getPerfil()) != null) {
				this.menu.add(elemento);
			}
		}
	}
	
	public List<MenuElemento> getMenu() {
		if (cambioUsuario()) {
			init();
		}
		return this.menu;
	}

	public String getVistaActual() {
		return vistaActual;
	}

	public void setVistaActual(String vistaActual) {
		this.vistaActual = vistaActual;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}

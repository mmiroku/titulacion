package mx.upiicsa.titulacion.ctrls;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.model.Usuario;
import mx.upiicsa.titulacion.pages.UsuarioPage;
import mx.upiicsa.titulacion.pages.CatalogoPage;
import mx.upiicsa.titulacion.service.UsuarioService;
import mx.upiicsa.titulacion.service.CatalogoService;
import mx.upiicsa.titulacion.util.Messages;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

@Named("cUsuario")
@RequestScoped

public class UsuarioCtrl implements Serializable {
	
	private static final long serialVersionUID = -8612967679860683584L;
	
	@Inject
	private UsuarioPage usuarioPage;
	@Inject
	private CatalogoPage catalogoPage;
	@EJB
	private UsuarioService usuarioService;
	@EJB
	private CatalogoService catalogoService;
		
	public String onFlowProcess(FlowEvent event) {
		
		return event.getNewStep();
	}

	public String getInit() {
		try {
			catalogoPage.setPerfiles(catalogoService.findAllPerfil());
			usuarioPage.setUsuarios(usuarioService.findAllUsuario());					
		} catch (TitulacionException e) {
			FacesMessage message = Messages.getMessage(
					e.getMessage(), null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;
	}
	
	public UsuarioPage getUsuarioPage() {
		return usuarioPage;
	}	
	
	public void setUsuarioPage(UsuarioPage usuarioPage) {
		this.usuarioPage = usuarioPage;
	}	
		
	public String guardarUsuario() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			usuarioService.save(usuarioPage.getUsuario());
			try {
				usuarioPage.setUsuarios(usuarioService.findAllUsuario());
				requestContext.update("formCenter:tabTitulacion:tblUsuarios");
				
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("formCenter:tabTitulacion:idEdit:pnlEdit");
			requestContext.update("msgsMaterias");
		}
		return null;
	}
	
	public String actualizarUsuario() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			usuarioService.update(usuarioPage.getUsuario());
			try {
				usuarioPage.setUsuarios(usuarioService.findAllUsuario());
				requestContext.update("formCenter:tabTitulacion:tblUsuarios");
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("formCenter:tabTitulacion:idEdit:pnlEdit");
			requestContext.update("msgsMaterias");
		}
		return null;
	}
	
	public String eliminarUsuario() {
		try {
			System.out.println("si llegue");			
			usuarioService.delete(usuarioPage.getUsuario().getIdUsuario());
			usuarioPage.setUsuarios(usuarioService.findAllUsuario());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formCenter:tabTitulacion:tblUsuarios");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
	
	public String seleccionarUsuario(Usuario usuario) {
		usuarioPage.setUsuario(usuario);
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("formCenter:tabTitulacion:idEdit:pnlEdit");
		return null;
	}

	public String limpiarUsuario() {
		usuarioPage.setUsuario(new Usuario());		
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("formCenter:tabTitulacion:idNew:pnlNew");
		return null;
	}	
	
	public String filtrarUsuario() {
		try {
			usuarioPage.setUsuarios(usuarioService.findByFilter(usuarioPage.getFiltro()));
			usuarioPage.setFiltro(new Usuario());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formCenter:tabTitulacion:tblUsuarios");
			requestContext.update("formRight:pnlFiltro");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
}

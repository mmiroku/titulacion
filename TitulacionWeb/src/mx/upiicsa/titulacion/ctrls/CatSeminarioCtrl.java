package mx.upiicsa.titulacion.ctrls;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.model.CatSeminario;
import mx.upiicsa.titulacion.pages.CatSeminarioPage;
import mx.upiicsa.titulacion.service.CatSeminarioService;
import mx.upiicsa.titulacion.util.Messages;
import mx.upiicsa.titulacion.web.menu.MenuSesion;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

@Named("cCatSeminario")
@RequestScoped

public class CatSeminarioCtrl implements Serializable {
	
	private static final long serialVersionUID = -8612967679860683584L;
	
	@Inject
	private CatSeminarioPage catSeminarioPage;
	@Inject
	private MenuSesion menuSesion;
	@EJB
	private CatSeminarioService catSeminarioService;
			
	public String onFlowProcess(FlowEvent event) {
		
		return event.getNewStep();
	}

	public String init() {
		try {			
			catSeminarioPage.setCatSeminarios(catSeminarioService.findAllCatSeminario());
			menuSesion.setVistaActual("catSeminarios");
		} catch (TitulacionException e) {
			FacesMessage message = Messages.getMessage(
					e.getMessage(), null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "catSeminarios";
	}
		
	public String guardarCatSeminario() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			catSeminarioService.save(catSeminarioPage.getCatSeminario());
			try {				
				catSeminarioPage.setCatSeminarios(catSeminarioService.findAllCatSeminario());
				requestContext.update("formCatSeminario:tblCatSeminarios");															
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("idNewCatSeminario:formNewCatSeminario:pnlNewCatSeminario");
			requestContext.update("msgsMaterias");
		}
		return null;
	}
	
	public String actualizarCatSeminario() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			catSeminarioService.update(catSeminarioPage.getCatSeminario());
			try {
				catSeminarioPage.setCatSeminarios(catSeminarioService.findAllCatSeminario());
				requestContext.update("formCatSeminario:tblCatSeminarios");
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("idEditCatSeminario:formEditCatSeminario:pnlEditCatSeminario");
			requestContext.update("msgsMaterias");
		}
		return null;
	}
	
	public String eliminarCatSeminario() {
		try {
			System.out.println("si llegue");			
			catSeminarioService.delete(catSeminarioPage.getCatSeminario().getIdCatalogoSeminario());
			catSeminarioPage.setCatSeminarios(catSeminarioService.findAllCatSeminario());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formCatSeminario:tblCatSeminarios");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
	
	public String seleccionarCatSeminario(CatSeminario catSeminario) {
		catSeminarioPage.setCatSeminario(catSeminario);
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("idEditCatSeminario:formEditCatSeminario:pnlEditCatSeminario");
		return null;
	}

	public String limpiarCatSeminario() {
		catSeminarioPage.setCatSeminario(new CatSeminario());		
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("idNewCatSeminario:formNewCatSeminario:pnlNewCatSeminario");
		return null;
	}	
	
	public String filtrarCatSeminario() {
		try {
			catSeminarioPage.setCatSeminarios(catSeminarioService.findByFilter(catSeminarioPage.getFiltro()));
			catSeminarioPage.setFiltro(new CatSeminario());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formCatSeminario:tblCatSeminarios");
			requestContext.update("formMenuCatSeminario:pnlFiltro");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
}

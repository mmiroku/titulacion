package mx.upiicsa.titulacion.ctrls;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.model.Cedula;
import mx.upiicsa.titulacion.pages.CedulaPage;
import mx.upiicsa.titulacion.pages.CatalogoPage;
import mx.upiicsa.titulacion.service.CedulaService;
import mx.upiicsa.titulacion.service.CatalogoService;
import mx.upiicsa.titulacion.util.Messages;
import mx.upiicsa.titulacion.web.menu.MenuSesion;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

@Named("cCedula")
@RequestScoped

public class CedulaCtrl implements Serializable {
	
	private static final long serialVersionUID = -8612967679860683584L;
	
	@Inject
	private CedulaPage cedulaPage;
	@Inject
	private CatalogoPage catalogoPage;
	@Inject
	private MenuSesion menuSesion;
	@EJB
	private CedulaService cedulaService;
	@EJB
	private CatalogoService catalogoService;
		
	public String onFlowProcess(FlowEvent event) {
		
		return event.getNewStep();
	}

	public String init() {
		try {			
			catalogoPage.setMaestros(catalogoService.findAllMaestro());
			cedulaPage.setCedulas(cedulaService.findAllCedula());
			menuSesion.setVistaActual("cedulas");
		} catch (TitulacionException e) {
			FacesMessage message = Messages.getMessage(
					e.getMessage(), null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "cedulas";
	}
		
	public String guardarCedula() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			cedulaService.save(cedulaPage.getCedula());
			try {
				cedulaPage.setCedulas(cedulaService.findAllCedula());
				requestContext.update("formCedula:tblCedulas");
				
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("idNewCedula:formNewCedula:pnlNewCedula");
			requestContext.update("msgsMaterias");
		}
		return null;
	}
	
	public String actualizarCedula() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			cedulaService.update(cedulaPage.getCedula());
			try {
				cedulaPage.setCedulas(cedulaService.findAllCedula());
				requestContext.update("formCedula:tblCedulas");
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("idEditCedula:formEditCedula:pnlEditCedula");
			requestContext.update("msgsMaterias");
		}
		return null;
	}
	
	public String eliminarCedula() {
		try {
			System.out.println("si llegue");			
			cedulaService.delete(cedulaPage.getCedula().getNumeroCedula());
			cedulaPage.setCedulas(cedulaService.findAllCedula());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formCedula:tblCedulas");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
	
	public String seleccionarCedula(Cedula cedula) {
		cedulaPage.setCedula(cedula);
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("idEditCedula:formEditCedula:pnlEditCedula");
		return null;
	}

	public String limpiarCedula() {
		cedulaPage.setCedula(new Cedula());		
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("idNewCedula:formNewCedula:pnlNewCedula");
		return null;
	}	
	
	public String filtrarCedula() {
		try {
			cedulaPage.setCedulas(cedulaService.findByFilter(cedulaPage.getFiltro()));
			cedulaPage.setFiltro(new Cedula());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formCenter:tabTitulacion:tblCedulas");
			requestContext.update("formRight:pnlFiltro");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
}

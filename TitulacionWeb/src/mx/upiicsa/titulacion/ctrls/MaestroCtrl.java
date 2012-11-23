package mx.upiicsa.titulacion.ctrls;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.model.Maestro;
import mx.upiicsa.titulacion.pages.CatalogoPage;
import mx.upiicsa.titulacion.pages.MaestroPage;
import mx.upiicsa.titulacion.service.MaestroService;
import mx.upiicsa.titulacion.service.CatalogoService;
import mx.upiicsa.titulacion.util.Messages;
import mx.upiicsa.titulacion.web.menu.MenuSesion;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;


@Named("cMaestro")
@RequestScoped

public class MaestroCtrl implements Serializable  {
	
private static final long serialVersionUID = -8612967679860683584L;
	
	@Inject
	private MaestroPage maestroPage;
	@Inject
	private CatalogoPage catalogoPage;
	@Inject
	private MenuSesion menuSesion;
	@EJB
	private MaestroService maestroService;
	@EJB
	private CatalogoService catalogoService;
		
	public String onFlowProcess(FlowEvent event) {
		
		return event.getNewStep();
	}	

	public String init() {
		try {
			catalogoPage.setAcademias(catalogoService.findAllAcademia());
			maestroPage.setMaestros(maestroService.findAllMaestro());
			menuSesion.setVistaActual("maestros");
		} catch (TitulacionException e) {
			FacesMessage message = Messages.getMessage(
					e.getMessage(), null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "maestros";
	}
		
	public String guardarMaestro() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			maestroService.save(maestroPage.getMaestro());
			try {
				maestroPage.setMaestros(maestroService.findAllMaestro());
				requestContext.update("formMaestro:tblMaestros");
				
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("idNewMaestro:formNewMaestro:pnlNewMaestro");
			requestContext.update("msgsAlumnos");
		}
		return null;
	}
	
	public String actualizarMaestro() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			maestroService.update(maestroPage.getMaestro());
			try {
				maestroPage.setMaestros(maestroService.findAllMaestro());
				requestContext.update("formMaestro:tblMaestros");
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("idEditMaestro:formEditMaestro:pnlEditMaestro");
			requestContext.update("msgsMaestros");
		}
		return null;
	}
	
	public String eliminarMaestro() {
		try {
			System.out.println("si llegue");			
			maestroService.delete(maestroPage.getMaestro().getIdMaestro());
			maestroPage.setMaestros(maestroService.findAllMaestro());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formMaestro:tblMaestros");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
	
	public String seleccionarMaestro(Maestro maestro) {
		maestroPage.setMaestro(maestro);
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("idEditMaestro:formEditMaestro:pnlEditMaestro");
		return null;
	}

	public String limpiarMaestro() {
		maestroPage.setMaestro(new Maestro());		
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("idNewMaestro:formNewMaestro:pnlNewMaestro");
		return null;
	}
	
	public String filtrarMaestros() {
		try {
			maestroPage.setMaestros(maestroService.findByFilter(maestroPage.getFiltro()));
			maestroPage.setFiltro(new Maestro());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formMaestro:tblMaestros");
			requestContext.update("formMenuMaestro:pnlFiltro");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
}

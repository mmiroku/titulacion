package mx.upiicsa.titulacion.ctrls;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.model.Alumno;
import mx.upiicsa.titulacion.model.Cedula;
import mx.upiicsa.titulacion.model.Seminario;
import mx.upiicsa.titulacion.pages.AlumnoPage;
import mx.upiicsa.titulacion.pages.SeminarioPage;
import mx.upiicsa.titulacion.pages.CedulaPage;
import mx.upiicsa.titulacion.pages.CatalogoPage;
import mx.upiicsa.titulacion.service.SeminarioService;
import mx.upiicsa.titulacion.service.CatalogoService;
import mx.upiicsa.titulacion.util.Messages;
import mx.upiicsa.titulacion.web.menu.MenuSesion;

import org.primefaces.context.RequestContext;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.FlowEvent;


@Named("cSeminario")
@RequestScoped

public class SeminarioCtrl implements Serializable  {
	
private static final long serialVersionUID = -8612967679860683584L;
	
	@Inject
	private SeminarioPage seminarioPage;
	@Inject
	private CatalogoPage catalogoPage;
	@Inject
	private MenuSesion menuSesion;
	@EJB
	private SeminarioService seminarioService;
	@EJB
	private CatalogoService catalogoService;
	@Inject
	private AlumnoPage alumnoPage;
	@Inject
	private CedulaPage cedulaPage;
		
	public String onFlowProcess(FlowEvent event) {
		
		return event.getNewStep();
	}	

	public String init() {
		try {
			catalogoPage.setCatSeminarios(catalogoService.findAllCatSeminario());
			catalogoPage.setCedulas(catalogoService.findAllCedula());
			seminarioPage.setSeminarios(seminarioService.findAllSeminario());
			cedulaPage.setCedulas(catalogoService.findAllCedula());
			menuSesion.setVistaActual("seminarios");
		} catch (TitulacionException e) {
			FacesMessage message = Messages.getMessage(
					e.getMessage(), null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "seminarios";
	}
	
	public String eliminarSeminario() {
		try {
			System.out.println("si llegue");			
			seminarioService.delete(seminarioPage.getSeminario().getIdSeminario());
			seminarioPage.setSeminarios(seminarioService.findAllSeminario());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formSeminario:tblSeminarios");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
	
	public String limpiarSeminario() {
		seminarioPage.setSeminario(new Seminario());
		seminarioPage.setPasantesSeleccionados(new ArrayList<Alumno>());
		seminarioPage.setExpositoresSeleccionados(new ArrayList<Cedula>());
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("idNewSeminario:formNewSeminario:pnlNewSeminario");
		return null;
	}
	
	public String seleccionarSeminario(Seminario seminario) {
		seminarioPage.setSeminario(seminario);
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("idEditSeminario:formEditSeminario:pnlEditSeminario");
		return null;
	}
	
	public String actualizarSeminario() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			seminarioService.update(seminarioPage.getSeminario());
			try {
				seminarioPage.setSeminarios(seminarioService.findAllSeminario());
				requestContext.update("formSeminario:tblSeminarios");
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("idEditSeminario:formEditSeminario:pnlEditSeminario");
			requestContext.update("msgsSeminarios");
		}
		return null;
	}
	
	public String guardarSeminario() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			seminarioService.save(seminarioPage.getSeminario());
			try {
				seminarioPage.setSeminarios(seminarioService.findAllSeminario());
				requestContext.update("formSeminario:tblSeminarios");
				
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("idNewSeminario:formNewSeminario:pnlNewSeminario");
			requestContext.update("msgsSeminarios");
		}
		return null;
	}
	
	public String filtrarSeminarios() {
		try {
			seminarioPage.setSeminarios(seminarioService.findByFilter(seminarioPage.getFiltro()));
			seminarioPage.setFiltro(new Seminario());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formSeminario:tblSeminarios");
			requestContext.update("formMenuSeminario:pnlFiltro");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
	
	public void onPasanteDrop(DragDropEvent ddEvent) {
		Alumno pasante = ((Alumno) ddEvent.getData());

		seminarioPage.getPasantesSeleccionados().add(pasante);
		alumnoPage.getAlumnos().remove(pasante);
	}
	
	public void onExpositorDrop(DragDropEvent ddEvent) {
		Cedula expositor = ((Cedula) ddEvent.getData());
		
		seminarioPage.getExpositoresSeleccionados().add(expositor);
		cedulaPage.getCedulas().remove(expositor);		
	}
		
}

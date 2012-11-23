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
import mx.upiicsa.titulacion.model.Expediente;
import mx.upiicsa.titulacion.pages.AlumnoPage;
import mx.upiicsa.titulacion.pages.CatalogoPage;
import mx.upiicsa.titulacion.pages.ExpedientePage;
import mx.upiicsa.titulacion.service.AlumnoService;
import mx.upiicsa.titulacion.service.CatalogoService;
import mx.upiicsa.titulacion.util.Messages;
import mx.upiicsa.titulacion.web.menu.MenuSesion;

import org.primefaces.context.RequestContext;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.FlowEvent;

@Named("cExpediente")
@RequestScoped
public class ExpedienteCtrl implements Serializable {

	private static final long serialVersionUID = 3818833121896995857L;

	@Inject
	private ExpedientePage expedientePage;
	@Inject
	private AlumnoPage alumnoPage;
	@Inject
	private CatalogoPage catalogoPage;
	@Inject
	private MenuSesion menuSesion;
	@EJB
	private AlumnoService alumnoService;
	@EJB
	private CatalogoService catalogoService;
	
	public String onFlowProcess(FlowEvent event) {

		return event.getNewStep();
	}

	public String init() {
		menuSesion.setVistaActual("expedientes");
		return "expedientes";
	}

	public String limpiarExpediente() {
		try {
			alumnoPage.setAlumnos(alumnoService.findAllAlumno());
			catalogoPage.setCedulas(catalogoService.findAllCedula());
		} catch (TitulacionException e) {
			FacesMessage message = Messages.getMessage(
					e.getMessage(), null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		expedientePage.setExpediente(new Expediente());
		expedientePage.setPasantesSeleccionados(new ArrayList<Alumno>());
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("idNewExpediente:formNewExpediente:pnlNewExpediente");
		return null;
	}
	
	public String guardarExpediente() {

		return null;
	}
	
	public void onPasanteDrop(DragDropEvent ddEvent) {
		Alumno pasante = ((Alumno) ddEvent.getData());

		expedientePage.getPasantesSeleccionados().add(pasante);
		alumnoPage.getAlumnos().remove(pasante);
	}

	public void onDirectorDrop(DragDropEvent ddEvent) {
		Cedula cedulaDirector = (Cedula) ddEvent.getData();
		
		expedientePage.getExpediente().setCedulaDirector(cedulaDirector);
		catalogoPage.getCedulas().remove(cedulaDirector);
	}
	
	public void onPresidenteDrop(DragDropEvent ddEvent) {
		Cedula cedulaPresidente = (Cedula) ddEvent.getData();
		
		expedientePage.getExpediente().setCedulaPresidente(cedulaPresidente);
		catalogoPage.getCedulas().remove(cedulaPresidente);
	}
}

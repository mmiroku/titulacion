package mx.upiicsa.titulacion.ctrls;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.model.AlumnoMateria;
import mx.upiicsa.titulacion.pages.AlumnoMateriaPage;
import mx.upiicsa.titulacion.service.AlumnoMateriaService;
import mx.upiicsa.titulacion.util.Messages;

import mx.upiicsa.titulacion.web.menu.MenuSesion;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;


@Named("cAlumnoMateria")
@RequestScoped
public class AlumnoMateriaCtrl implements Serializable {

	private static final long serialVersionUID = -8612967679860683584L;
	
	@Inject
	private AlumnoMateriaPage alumnoMateriaPage;	
	@Inject
	private MenuSesion menuSesion;
	@EJB
	private AlumnoMateriaService alumnoMateriaService;	
	
	public String onFlowProcess(FlowEvent event) {
		
		return event.getNewStep();
	}

	public String init() {
		try {
			alumnoMateriaPage.setAlumnoMaterias(alumnoMateriaService.findAllAlumnoMateria());
			menuSesion.setVistaActual("Calificaciones");
		} catch (TitulacionException e) {
			FacesMessage message = Messages.getMessage(
					e.getMessage(), null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "Calificaciones";
	}
	
	public String filtrarAlumnoMaterias() {
		try {
			alumnoMateriaPage.setAlumnoMaterias(alumnoMateriaService.findByFilter(alumnoMateriaPage.getFiltro()));
			alumnoMateriaPage.setFiltro(new AlumnoMateria());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formAlumnoMateria:tblAlumnoMaterias");
			requestContext.update("formMenuAlumnoMateria:pnlFiltro");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
		
	public String actualizarAlumnoMateria() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			alumnoMateriaService.update(alumnoMateriaPage.getAlumnoMateria());
			try {
				alumnoMateriaPage.setAlumnoMaterias(alumnoMateriaService.findAllAlumnoMateria());
				requestContext.update("formAlumnoMateria:tblAlumnoMaterias");
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("idEditAlumnoMateria:formEditAlumnoMateria:pnlEditAlumnoMateria");
			requestContext.update("msgsAlumnoMaterias");
		}
		return null;
	}
	
	public String seleccionarAlumnoMateria(AlumnoMateria alumnoMateria) {
		alumnoMateriaPage.setAlumnoMateria(alumnoMateria);
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("idEditAlumnoMateria:formEditAlumnoMateria:pnlEditAlumnoMateria");
		return null;
	}

	public String limpiarAlumnoMateria() {
		alumnoMateriaPage.setAlumnoMateria(new AlumnoMateria());
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("idNewAlumnoMateria:formNewAlumnoMateria:pnlNewAlumnoMateria");
		return null;
	}
}

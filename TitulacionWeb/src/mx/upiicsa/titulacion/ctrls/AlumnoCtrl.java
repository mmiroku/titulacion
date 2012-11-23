package mx.upiicsa.titulacion.ctrls;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.model.Alumno;
import mx.upiicsa.titulacion.model.Direccion;
import mx.upiicsa.titulacion.pages.AlumnoPage;
import mx.upiicsa.titulacion.pages.CatalogoPage;
import mx.upiicsa.titulacion.service.AlumnoService;
import mx.upiicsa.titulacion.service.CatalogoService;
import mx.upiicsa.titulacion.util.Messages;
import mx.upiicsa.titulacion.web.menu.MenuSesion;

import org.primefaces.context.RequestContext;
import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.FlowEvent;

@Named("cAlumno")
@RequestScoped
public class AlumnoCtrl implements Serializable {

	private static final long serialVersionUID = -8612967679860683584L;
	
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
		return "alumnos";
	}
	
	public String filtrarAlumnos() {
		try {
			alumnoPage.setAlumnos(alumnoService.findByFilter(alumnoPage.getFiltro()));
			alumnoPage.setFiltro(new Alumno());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formAlumno:tblAlumnos");
			requestContext.update("formMenuAlumno:pnlFiltro");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
	
	public String guardarAlumno() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			alumnoService.save(alumnoPage.getAlumno());
			try {
				alumnoPage.setAlumnos(alumnoService.findAllAlumno());
				requestContext.update("formAlumno:tblAlumnos");
				
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("idNewAlumno:formNewAlumno:pnlNewAlumno");
			requestContext.update("msgsAlumnos");
		}
		return null;
	}

	public String actualizarAlumno() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			alumnoService.update(alumnoPage.getAlumno());
			try {
				alumnoPage.setAlumnos(alumnoService.findAllAlumno());
				requestContext.update("formAlumno:tblAlumnos");
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("idEditAlumno:formEditAlumno:pnlEditAlumno");
			requestContext.update("msgsAlumnos");
		}
		return null;
	}

	public String eliminarAlumno() {
		try {
			System.out.println("si llegue");
			alumnoService.delete(alumnoPage.getAlumno().getBoleta());
			alumnoPage.setAlumnos(alumnoService.findAllAlumno());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formAlumno:tblAlumnos");
		} catch (TitulacionException e) {
			
		}
		return null;
	}

	public String seleccionarAlumno(Alumno alumno) {
		alumnoPage.setAlumno(alumno);
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("idEditAlumno:formEditAlumno:pnlEditAlumno");
		return null;
	}

	public String limpiarAlumno() {
		alumnoPage.setAlumno(new Alumno());
		alumnoPage.getAlumno().setDireccion(new Direccion());
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("idNewAlumno:formNewAlumno:pnlNewAlumno");
		return null;
	}

	/**
	 * M&eacute;todo para obtener la Edad del Alumno en base a la fecha de
	 * nacimiento capturada.
	 * 
	 * @param event
	 */
	public void calcularEdad(DateSelectEvent event) {
		int edad = obtenerEdad(event.getDate());
		alumnoPage.getAlumno().setEdad(edad);
	}

	/**
	 * Realiza el calculo de la edad a partir de la fecha de nacimiento.
	 * 
	 * @param fechaNac
	 * @return
	 */
	private int obtenerEdad(Date fechaNac) {
		Date fechaHoy = new Date();
		int edad = 0;
		int factor = 0;
		Calendar birth = new GregorianCalendar();
		Calendar today = new GregorianCalendar();
		birth.setTime(fechaNac);
		today.setTime(fechaHoy);
		if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
			if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
				if (today.get(Calendar.DATE) < birth.get(Calendar.DATE)) {
					factor = -1;
				}
			} else {
				factor = -1;
			}
		}
		edad = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR)) + factor;
		return edad;
	}
}

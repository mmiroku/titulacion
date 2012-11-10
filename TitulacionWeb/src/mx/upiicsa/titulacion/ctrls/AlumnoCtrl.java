package mx.upiicsa.titulacion.ctrls;

import java.io.Serializable;

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

import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

@Named("cAlumno")
@RequestScoped
public class AlumnoCtrl implements Serializable {

	private static final long serialVersionUID = -8612967679860683584L;
	
	@Inject
	private AlumnoPage alumnoPage;
	@Inject
	private CatalogoPage catalogoPage;
	@EJB
	private AlumnoService alumnoService;
	@EJB
	private CatalogoService catalogoService;
	
	public String onFlowProcess(FlowEvent event) {
		
		return event.getNewStep();
	}

	public String getInit() {
		try {
			catalogoPage.setCarreras(catalogoService.findAllCarrera());
			catalogoPage.setSexos(catalogoService.findAllSexo());
			alumnoPage.setAlumnos(alumnoService.findAllAlumno());
		} catch (TitulacionException e) {
			FacesMessage message = Messages.getMessage(
					e.getMessage(), null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;
	}
	
	public String filtrarAlumnos() {
		try {
			alumnoPage.setAlumnos(alumnoService.findByFilter(alumnoPage.getFiltro()));
			alumnoPage.setFiltro(new Alumno());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formCenter:tabTitulacion:tblAlumnos");
			requestContext.update("formRight:pnlFiltro");
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
				requestContext.update("formCenter:tabTitulacion:tblAlumnos");
				
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("formCenter:tabTitulacion:idEdit:pnlEdit");
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
				requestContext.update("formCenter:tabTitulacion:tblAlumnos");
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("formCenter:tabTitulacion:idEdit:pnlEdit");
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
			requestContext.update("formCenter:tabTitulacion:tblAlumnos");
		} catch (TitulacionException e) {
			
		}
		return null;
	}

	public String seleccionarAlumno(Alumno alumno) {
		alumnoPage.setAlumno(alumno);
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("formCenter:tabTitulacion:idEdit:pnlEdit");
		return null;
	}

	public String limpiarAlumno() {
		alumnoPage.setAlumno(new Alumno());
		alumnoPage.getAlumno().setDireccion(new Direccion());
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("formCenter:tabTitulacion:idNew:pnlNew");
		return null;
	}
}

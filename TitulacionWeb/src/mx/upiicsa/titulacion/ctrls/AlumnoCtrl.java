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
	
	public String guardarAlumno() {
		alumnoService.save(alumnoPage.getAlumno());
		try {
			alumnoPage.setAlumnos(alumnoService.findAllAlumno());
			alumnoPage.setAlumno(new Alumno());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formCenter:tblAlumnos");
		} catch (TitulacionException e) {
			
		}
		return null;
	}

	public AlumnoPage getAlumnoPage() {
		return alumnoPage;
	}

	public void setAlumnoPage(AlumnoPage alumnoPage) {
		this.alumnoPage = alumnoPage;
	}

}

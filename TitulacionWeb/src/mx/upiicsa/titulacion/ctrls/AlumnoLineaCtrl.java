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
import mx.upiicsa.titulacion.model.AlumnoLinea;
import mx.upiicsa.titulacion.model.Materia;
import mx.upiicsa.titulacion.pages.CatalogoPage;
import mx.upiicsa.titulacion.pages.AlumnoLineaPage;
import mx.upiicsa.titulacion.pages.MateriaPage;
import mx.upiicsa.titulacion.service.AlumnoLineaService;
import mx.upiicsa.titulacion.service.CatalogoService;
import mx.upiicsa.titulacion.util.Messages;
import mx.upiicsa.titulacion.web.menu.MenuSesion;

import org.primefaces.context.RequestContext;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.FlowEvent;


@Named("cAlumnoLinea")
@RequestScoped

public class AlumnoLineaCtrl implements Serializable  {
	
private static final long serialVersionUID = -8612967679860683584L;
	
	@Inject
	private AlumnoLineaPage alumnoLineaPage;
	@Inject
	private CatalogoPage catalogoPage;
	@Inject
	private MenuSesion menuSesion;
	@Inject
	private MateriaPage materiaPage;
	@EJB
	private AlumnoLineaService alumnoLineaService;
	@EJB
	private CatalogoService catalogoService;
		
	public String onFlowProcess(FlowEvent event) {
		
		return event.getNewStep();
	}	

	public String init() {
		try {			
			catalogoPage.setProyectos(catalogoService.findAllProyecto());			
			catalogoPage.setLineas(catalogoService.findAllLinea());
			catalogoPage.setAlumnos(catalogoService.findAllAlumno());
			materiaPage.setMaterias(catalogoService.findAllMateria());
			alumnoLineaPage.setAlumnoLineas(alumnoLineaService.findAllAlumnoLinea());			
			menuSesion.setVistaActual("Linea");
		} catch (TitulacionException e) {
			FacesMessage message = Messages.getMessage(
					e.getMessage(), null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "Linea";
	}
		
	public String guardarAlumnoLinea() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			alumnoLineaService.save(alumnoLineaPage.getAlumnoLinea(), alumnoLineaPage.getMateriasSeleccionadas());
			try {
				alumnoLineaPage.setAlumnoLineas(alumnoLineaService.findAllAlumnoLinea());
				requestContext.update("formAlumnoLinea:tblAlumnoLineas");
				
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("idNewAlumnoLinea:formNewAlumnoLinea:pnlNewAlumnoLinea");
			requestContext.update("msgsAlumnos");
		}
		return null;
	}
	
	public String actualizarAlumnoLinea() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			alumnoLineaService.update(alumnoLineaPage.getAlumnoLinea());
			try {
				alumnoLineaPage.setAlumnoLineas(alumnoLineaService.findAllAlumnoLinea());
				requestContext.update("formAlumnoLinea:tblAlumnoLineas");
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("idEditAlumnoLinea:formEditAlumnoLinea:pnlEditAlumnoLinea");
			requestContext.update("msgsAlumnoLineas");
		}
		return null;
	}
	
	public String eliminarAlumnoLinea() {
		try {
			System.out.println("si llegue");			
			alumnoLineaService.delete(alumnoLineaPage.getAlumnoLinea().getIdAlumnoLinea());
			alumnoLineaPage.setAlumnoLineas(alumnoLineaService.findAllAlumnoLinea());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formAlumnoLinea:tblAlumnoLineas");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
	
	public String seleccionarAlumnoLinea(AlumnoLinea alumnoLinea) {
		alumnoLineaPage.setAlumnoLinea(alumnoLinea);
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("idEditAlumnoLinea:formEditAlumnoLinea:pnlEditAlumnoLinea");
		return null;
	}

	public String limpiarAlumnoLinea() {
		alumnoLineaPage.setAlumnoLinea(new AlumnoLinea());	
		alumnoLineaPage.setMateriasSeleccionadas(new ArrayList<Materia>());
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("idNewAlumnoLinea:formNewAlumnoLinea:pnlNewAlumnoLinea");
		return null;
	}
	
	public String filtrarAlumnoLineas() {
		try {
			alumnoLineaPage.setAlumnoLineas(alumnoLineaService.findByFilter(alumnoLineaPage.getFiltro()));
			alumnoLineaPage.setFiltro(new AlumnoLinea());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formAlumnoLinea:tblAlumnoLineas");
			requestContext.update("formMenuAlumnoLinea:pnlFiltro");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
	
	public void onMateriasDrop(DragDropEvent ddEvent) {
		
		Materia materia = ((Materia) ddEvent.getData());
		
		alumnoLineaPage.getMateriasSeleccionadas().add(materia);
		materiaPage.getMaterias().remove(materia);		
	}
}

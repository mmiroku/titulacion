package mx.upiicsa.titulacion.ctrls;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
import mx.upiicsa.titulacion.pages.FilterPage;
import mx.upiicsa.titulacion.service.AlumnoService;
import mx.upiicsa.titulacion.service.CatalogoService;
import mx.upiicsa.titulacion.service.ExpedienteService;
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
	private FilterPage filterPage;
	@Inject
	private MenuSesion menuSesion;
	@EJB
	private ExpedienteService expedienteService;
	@EJB
	private AlumnoService alumnoService;
	@EJB
	private CatalogoService catalogoService;
	
	public String onFlowProcess(FlowEvent event) {

		return event.getNewStep();
	}

	public String init() {
		try {
			expedientePage.setExpedientes(expedienteService.findAllExpediente());
			menuSesion.setVistaActual("expedientes");
		} catch (TitulacionException e) {
			FacesMessage message = Messages.getMessage(
					e.getMessage(), null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "expedientes";
	}

	public String limpiarExpediente() {
		try {
			List<Alumno> alumnos = alumnoService.findAllAlumno();
			alumnoPage.setAlumnos(alumnos);
			filterPage.setFilteredAlumnos(alumnos);
			List<Cedula> cedulas = catalogoService.findAllCedula();
			catalogoPage.setCedulas(cedulas);
			filterPage.setFilteredCedulas(cedulas);
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
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			expedienteService.save(expedientePage.getExpediente(), expedientePage.getPasantesSeleccionados());
			try {
				expedientePage.setExpedientes(expedienteService.findAllExpediente());
				requestContext.update("formExpediente:tblExpedientes");
				
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("idNewExpediente:formNewExpediente:pnlNewExpediente");
			requestContext.update("msgsExpedientes");
		}
		return null;
	}
	
	public void onPasanteDrop(DragDropEvent ddEvent) {
		Alumno pasante = ((Alumno) ddEvent.getData());
		expedientePage.getPasantesSeleccionados().add(pasante);
		alumnoPage.getAlumnos().remove(pasante);
		filterPage.setFilteredAlumnos(alumnoPage.getAlumnos());
	}

	public void onDirectorDrop(DragDropEvent ddEvent) {
		Cedula cedulaDirector = (Cedula) ddEvent.getData();
		if (expedientePage.getExpediente().getCedulaDirector() != null) {
			catalogoPage.getCedulas().add(expedientePage.getExpediente().getCedulaDirector());
		}
		expedientePage.getExpediente().setCedulaDirector(cedulaDirector);
		catalogoPage.getCedulas().remove(cedulaDirector);
		filterPage.setFilteredCedulas(catalogoPage.getCedulas());
	}
	
	public void onPresidenteDrop(DragDropEvent ddEvent) {
		Cedula cedulaPresidente = (Cedula) ddEvent.getData();
		if (expedientePage.getExpediente().getCedulaPresidente() != null) {
			catalogoPage.getCedulas().add(expedientePage.getExpediente().getCedulaPresidente());
		}
		expedientePage.getExpediente().setCedulaPresidente(cedulaPresidente);
		catalogoPage.getCedulas().remove(cedulaPresidente);
		filterPage.setFilteredCedulas(catalogoPage.getCedulas());
	}
	
	public void onSecretarioDrop(DragDropEvent ddEvent) {
		Cedula cedulaSecretario = (Cedula) ddEvent.getData();
		if (expedientePage.getExpediente().getCedulaSecretario() != null) {
			catalogoPage.getCedulas().add(expedientePage.getExpediente().getCedulaSecretario());
		}
		expedientePage.getExpediente().setCedulaSecretario(cedulaSecretario);
		catalogoPage.getCedulas().remove(cedulaSecretario);
		filterPage.setFilteredCedulas(catalogoPage.getCedulas());
	}
	
	public void onVocal1Drop(DragDropEvent ddEvent) {
		Cedula cedulaVocal1 = (Cedula) ddEvent.getData();
		if (expedientePage.getExpediente().getCedulaVocal1() != null) {
			catalogoPage.getCedulas().add(expedientePage.getExpediente().getCedulaVocal1());
		}
		expedientePage.getExpediente().setCedulaVocal1(cedulaVocal1);
		catalogoPage.getCedulas().remove(cedulaVocal1);
		filterPage.setFilteredCedulas(catalogoPage.getCedulas());
	}
	
	public void onVocal2Drop(DragDropEvent ddEvent) {
		Cedula cedulaVocal2 = (Cedula) ddEvent.getData();
		if (expedientePage.getExpediente().getCedulaVocal2() != null) {
			catalogoPage.getCedulas().add(expedientePage.getExpediente().getCedulaVocal2());
		}
		expedientePage.getExpediente().setCedulaVocal2(cedulaVocal2);
		catalogoPage.getCedulas().remove(cedulaVocal2);
		filterPage.setFilteredCedulas(catalogoPage.getCedulas());
	}
	
	public void onVocal3Drop(DragDropEvent ddEvent) {
		Cedula cedulaVocal3 = (Cedula) ddEvent.getData();
		if (expedientePage.getExpediente().getCedulaVocal3() != null) {
			catalogoPage.getCedulas().add(expedientePage.getExpediente().getCedulaVocal3());
		}
		expedientePage.getExpediente().setCedulaVocal3(cedulaVocal3);
		catalogoPage.getCedulas().remove(cedulaVocal3);
		filterPage.setFilteredCedulas(catalogoPage.getCedulas());
	}
}

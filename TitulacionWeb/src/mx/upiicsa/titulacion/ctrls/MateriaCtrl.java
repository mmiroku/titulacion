package mx.upiicsa.titulacion.ctrls;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.model.Materia;
import mx.upiicsa.titulacion.pages.CatalogoPage;
import mx.upiicsa.titulacion.pages.MateriaPage;
import mx.upiicsa.titulacion.service.MateriaService;
import mx.upiicsa.titulacion.service.CatalogoService;
import mx.upiicsa.titulacion.util.Messages;
import mx.upiicsa.titulacion.web.menu.MenuSesion;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

@Named("cMateria")
@RequestScoped

public class MateriaCtrl implements Serializable {
	
	private static final long serialVersionUID = -8612967679860683584L;
	
	@Inject
	private MateriaPage materiaPage;
	@Inject
	private CatalogoPage catalogoPage;
	@Inject
	private MenuSesion menuSesion;
	@EJB
	private MateriaService materiaService;
	@EJB
	private CatalogoService catalogoService;
		
	public String onFlowProcess(FlowEvent event) {
		
		return event.getNewStep();
	}	

	public String init() {
		try {
			catalogoPage.setLineas(catalogoService.findAllLinea());
			catalogoPage.setAcademias(catalogoService.findAllAcademia());
			materiaPage.setMaterias(materiaService.findAllMateria());
			menuSesion.setVistaActual("materias");
		} catch (TitulacionException e) {
			FacesMessage message = Messages.getMessage(
					e.getMessage(), null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "materias";
	}
		
	public String guardarMateria() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			materiaService.save(materiaPage.getMateria());
			try {
				materiaPage.setMaterias(materiaService.findAllMateria());
				requestContext.update("formMateria:tblMaterias");
				
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("idNewMateria:formNewMateria:pnlNewMateria");
			requestContext.update("msgsMaterias");
		}
		return null;
	}
	
	public String actualizarMateria() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			materiaService.update(materiaPage.getMateria());
			try {
				materiaPage.setMaterias(materiaService.findAllMateria());
				requestContext.update("formMateria:tblMaterias");
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("idEditMateria:formEditMateria:pnlEditMateria");
			requestContext.update("msgsMaterias");
		}
		return null;
	}
	
	public String eliminarMateria() {
		try {
			System.out.println("si llegue");			
			materiaService.delete(materiaPage.getMateria().getIdMateria());
			materiaPage.setMaterias(materiaService.findAllMateria());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formMateria:tblMaterias");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
	
	public String seleccionarMateria(Materia materia) {
		materiaPage.setMateria(materia);
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("idEditMateria:formEditMateria:pnlEditMateria");
		return null;
	}

	public String limpiarMateria() {
		materiaPage.setMateria(new Materia());		
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("idNewMateria:formNewMateria:pnlNewMateria");
		return null;
	}
	
	public String filtrarMaterias() {
		try {
			materiaPage.setMaterias(materiaService.findByFilter(materiaPage.getFiltro()));
			materiaPage.setFiltro(new Materia());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formMateria:tblMaterias");
			requestContext.update("formMenuMateria:pnlFiltro");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
		
}

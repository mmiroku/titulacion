package mx.upiicsa.titulacion.ctrls;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.model.Seminario;
import mx.upiicsa.titulacion.pages.SeminarioPage;
import mx.upiicsa.titulacion.pages.CatalogoPage;
import mx.upiicsa.titulacion.service.SeminarioService;
import mx.upiicsa.titulacion.service.CatalogoService;
import mx.upiicsa.titulacion.util.Messages;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;


@Named("cSeminario")
@RequestScoped

public class SeminarioCtrl implements Serializable  {
	
private static final long serialVersionUID = -8612967679860683584L;
	
	@Inject
	private SeminarioPage seminarioPage;
	@Inject
	private CatalogoPage catalogoPage;
	@EJB
	private SeminarioService seminarioService;
	@EJB
	private CatalogoService catalogoService;
		
	public String onFlowProcess(FlowEvent event) {
		
		return event.getNewStep();
	}	

	public String getInit() {
		try {
			catalogoPage.setCatSeminarios(catalogoService.findAllCatSeminario());
			catalogoPage.setCedulas(catalogoService.findAllCedula());
			seminarioPage.setSeminarios(seminarioService.findAllSeminario());			
		} catch (TitulacionException e) {
			FacesMessage message = Messages.getMessage(
					e.getMessage(), null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;
	}
		
	public void setSeminarioPage(SeminarioPage seminarioPage) {
		this.seminarioPage = seminarioPage;
	}
	
	public SeminarioPage getSeminarioPage() {
		return seminarioPage;
	}
	
	public String eliminarSeminario() {
		try {
			System.out.println("si llegue");			
			seminarioService.delete(seminarioPage.getSeminario().getIdSeminario());
			seminarioPage.setSeminarios(seminarioService.findAllSeminario());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formCenter:tabTitulacion:tblSeminarios");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
	
	public String limpiarSeminario() {
		seminarioPage.setSeminario(new Seminario());		
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("formCenter:tabTitulacion:idNew:pnlNew");
		return null;
	}
	
	public String seleccionarSeminario(Seminario seminario) {
		seminarioPage.setSeminario(seminario);
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("formCenter:tabTitulacion:idEdit:pnlEdit");
		return null;
	}
	
	public String actualizarSeminario() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			seminarioService.update(seminarioPage.getSeminario());
			try {
				seminarioPage.setSeminarios(seminarioService.findAllSeminario());
				requestContext.update("formCenter:tabTitulacion:tblSeminarios");
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("formCenter:tabTitulacion:idEdit:pnlEdit");
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
				requestContext.update("formCenter:tabTitulacion:tblSeminarios");
				
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("formCenter:tabTitulacion:idEdit:pnlEdit");
			requestContext.update("msgsMaterias");
		}
		return null;
	}
	
	public String filtrarSeminarios() {
		try {
			seminarioPage.setSeminarios(seminarioService.findByFilter(seminarioPage.getFiltro()));
			seminarioPage.setFiltro(new Seminario());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formCenter:tabTitulacion:tblSeminarios");
			requestContext.update("formRight:pnlFiltro");
		} catch (TitulacionException e) {
			
		}
		return null;
	}	
}

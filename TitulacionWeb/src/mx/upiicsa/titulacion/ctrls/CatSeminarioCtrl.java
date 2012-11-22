package mx.upiicsa.titulacion.ctrls;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.model.CatSeminario;
import mx.upiicsa.titulacion.pages.CatSeminarioPage;
import mx.upiicsa.titulacion.service.CatSeminarioService;
import mx.upiicsa.titulacion.util.Messages;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

@Named("cCatSeminario")
@RequestScoped

public class CatSeminarioCtrl implements Serializable {
	
	private static final long serialVersionUID = -8612967679860683584L;
	
	@Inject
	private CatSeminarioPage catSeminarioPage;
	@EJB
	private CatSeminarioService catSeminarioService;
			
	public String onFlowProcess(FlowEvent event) {
		
		return event.getNewStep();
	}

	public String getInit() {
		try {			
			catSeminarioPage.setCatSeminarios(catSeminarioService.findAllCatSeminario());					
		} catch (TitulacionException e) {
			FacesMessage message = Messages.getMessage(
					e.getMessage(), null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;
	}
	
	public CatSeminarioPage getCatSeminarioPage() {
		return catSeminarioPage;
	}	
	
	public void setCatSeminarioPage(CatSeminarioPage catSeminarioPage) {
		this.catSeminarioPage = catSeminarioPage;
	}	
		
	public String guardarCatSeminario() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			catSeminarioService.save(catSeminarioPage.getCatSeminario());
			try {				
				catSeminarioPage.setCatSeminarios(catSeminarioService.findAllCatSeminario());
				requestContext.update("formCenter:tabTitulacion:tblCatSeminarios");															
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("formCenter:tabTitulacion:idEdit:pnlEdit");
			requestContext.update("msgsMaterias");
		}
		return null;
	}
	
	public String actualizarCatSeminario() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			catSeminarioService.update(catSeminarioPage.getCatSeminario());
			try {
				catSeminarioPage.setCatSeminarios(catSeminarioService.findAllCatSeminario());
				requestContext.update("formCenter:tabTitulacion:tblCatSeminarios");
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("formCenter:tabTitulacion:idEdit:pnlEdit");
			requestContext.update("msgsMaterias");
		}
		return null;
	}
	
	public String eliminarCatSeminario() {
		try {
			System.out.println("si llegue");			
			catSeminarioService.delete(catSeminarioPage.getCatSeminario().getIdCatalogoSeminario());
			catSeminarioPage.setCatSeminarios(catSeminarioService.findAllCatSeminario());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formCenter:tabTitulacion:tblCatSeminarios");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
	
	public String seleccionarCatSeminario(CatSeminario catSeminario) {
		catSeminarioPage.setCatSeminario(catSeminario);
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("formCenter:tabTitulacion:idEdit:pnlEdit");
		return null;
	}

	public String limpiarCatSeminario() {
		catSeminarioPage.setCatSeminario(new CatSeminario());		
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("formCenter:tabTitulacion:catSeminarioDetail");
		return null;
	}	
	
	public String filtrarCatSeminario() {
		try {
			catSeminarioPage.setCatSeminarios(catSeminarioService.findByFilter(catSeminarioPage.getFiltro()));
			catSeminarioPage.setFiltro(new CatSeminario());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formCenter:tabTitulacion:tblCatSeminarios");
			requestContext.update("formRight:pnlFiltro");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
}

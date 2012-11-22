package mx.upiicsa.titulacion.ctrls;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.model.CatLinea;
import mx.upiicsa.titulacion.pages.CatLineaPage;
import mx.upiicsa.titulacion.pages.CatalogoPage;
import mx.upiicsa.titulacion.service.CatLineaService;
import mx.upiicsa.titulacion.service.CatalogoService;
import mx.upiicsa.titulacion.util.Messages;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

@Named("cCatLinea")
@RequestScoped

public class CatLineaCtrl implements Serializable {
	
	private static final long serialVersionUID = -8612967679860683584L;
	
	@Inject
	private CatLineaPage catLineaPage;
	@Inject
	private CatalogoPage catalogoPage;
	@EJB
	private CatLineaService catLineaService;
	@EJB
	private CatalogoService catalogoService;
		
	public String onFlowProcess(FlowEvent event) {
		
		return event.getNewStep();
	}

	public String getInit() {
		try {			
			catalogoPage.setCarreras(catalogoService.findAllCarrera());
			catLineaPage.setCatLineas(catLineaService.findAllCatLinea());					
		} catch (TitulacionException e) {
			FacesMessage message = Messages.getMessage(
					e.getMessage(), null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;
	}
	
	
	public CatLineaPage getCatLineaPage() {
		return catLineaPage;
	}
	
	public void setCatLineaPage(CatLineaPage catLineaPage) {
		this.catLineaPage = catLineaPage;
	}	
		
	public String guardarCatLinea() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			catLineaService.save(catLineaPage.getCatLinea());
			try {
				catLineaPage.setCatLineas(catLineaService.findAllCatLinea());
				requestContext.update("formCenter:tabTitulacion:tblCatLineas");
				
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("formCenter:tabTitulacion:idEdit:pnlEdit");
			requestContext.update("msgsMaterias");
		}
		return null;
	}
	
	public String actualizarCatLinea() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			requestContext.addCallbackParam("isValid", true);
			catLineaService.update(catLineaPage.getCatLinea());
			try {
				catLineaPage.setCatLineas(catLineaService.findAllCatLinea());
				requestContext.update("formCenter:tabTitulacion:tblCatLineas");
			} catch (TitulacionException e) {

			}
		} else {
			requestContext.addCallbackParam("isValid", false);
			requestContext.update("formCenter:tabTitulacion:idEdit:pnlEdit");
			requestContext.update("msgsMaterias");
		}
		return null;
	}
	
	public String eliminarCatLinea() {
		try {
			System.out.println("si llegue");			
			catLineaService.delete(catLineaPage.getCatLinea().getIdLinea());
			catLineaPage.setCatLineas(catLineaService.findAllCatLinea());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formCenter:tabTitulacion:tblCatLineas");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
	
	public String seleccionarCatLinea(CatLinea catLinea) {
		catLineaPage.setCatLinea(catLinea);
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("formCenter:tabTitulacion:idEdit:pnlEdit");
		return null;
	}

	public String limpiarCatLinea() {
		catLineaPage.setCatLinea(new CatLinea());		
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("formCenter:tabTitulacion:idNew:pnlNew");
		return null;
	}	
	
	public String filtrarCatLinea() {
		try {
			catLineaPage.setCatLineas(catLineaService.findByFilter(catLineaPage.getFiltro()));
			catLineaPage.setFiltro(new CatLinea());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formCenter:tabTitulacion:tblCatLineas");
			requestContext.update("formRight:pnlFiltro");
		} catch (TitulacionException e) {
			
		}
		return null;
	}
}

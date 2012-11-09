package mx.upiicsa.titulacion.ctrls;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import mx.upiicsa.titulacion.exceptions.TitulacionException;
import mx.upiicsa.titulacion.model.Maestro;
import mx.upiicsa.titulacion.pages.MaestroPage;
import mx.upiicsa.titulacion.pages.CatalogoPage;
import mx.upiicsa.titulacion.service.MaestroService;
import mx.upiicsa.titulacion.service.CatalogoService;
import mx.upiicsa.titulacion.util.Messages;

import org.primefaces.context.RequestContext;


@Named("cMaestro")
@RequestScoped

public class MaestroCtrl implements Serializable  {
	
private static final long serialVersionUID = -8612967679860683584L;
	
	@Inject
	private MaestroPage maestroPage;
	@Inject
	private CatalogoPage catalogoPage;
	@EJB
	private MaestroService maestroService;
	@EJB
	private CatalogoService catalogoService;
		
	

	public String getInit() {
		try {
			catalogoPage.setAcademias(catalogoService.findAllAcademia());
			maestroPage.setMaestros(maestroService.findAllMaestro());			
		} catch (TitulacionException e) {
			FacesMessage message = Messages.getMessage(
					e.getMessage(), null);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;
	}
	
	public String guardarMaestro() {		
		maestroService.save(maestroPage.getMaestro());		
		try {
			maestroPage.setMaestros(maestroService.findAllMaestro());
			maestroPage.setMaestro(new Maestro());
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.update("formCenter:tblMaestros");
		} catch (TitulacionException e) {
			
		}
		return null;
	}

	public MaestroPage getMaestroPage() {
		return maestroPage;
	}
	
	public void setMaestroPage(MaestroPage maestroPage) {
		this.maestroPage = maestroPage;
	}
	
}

package mx.upiicsa.titulacion.web.menu;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

@Named
@ConversationScoped
public class Menu implements Serializable {

	private static final long serialVersionUID = 4902667320358674274L;

	@Inject
	private MenuSesion menuSesion;
	
	private final MenuModel model = new DefaultMenuModel();
	
	private final Map<String, Integer> indices = new HashMap<String, Integer>();
	
	private Integer indice;
	
	@PostConstruct
	public void init() {
		ExpressionFactory expFact = FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
		ELContext elCtx = FacesContext.getCurrentInstance().getELContext();
		
		int indice = 0;
		for (MenuElemento elemento:menuSesion.getMenu()) {
			indices.put(elemento.getEtiqueta(), indice++);
			MenuItem menuItem = (MenuItem) FacesContext.getCurrentInstance().getApplication().createComponent(MenuItem.COMPONENT_TYPE);
			menuItem.setId(elemento.getEtiqueta());
			menuItem.setValue(elemento.getEtiqueta()); // TODO obtener del bundle
//			menuItem.setUrl(elemento.getUrl());
			MethodExpression actionExp = expFact.createMethodExpression(elCtx, elemento.getUrl(), String.class, new Class[0]);
			menuItem.setActionExpression(actionExp);
			menuItem.setAjax(false);
			model.addMenuItem(menuItem);
		}
	}

	public MenuModel getModel() {
		return model;
	}
	
	public Integer buscaIndice(String elemento) {
		return indices.get(elemento);
	}

	public Integer getIndice() {
		if (indice == null) {
			indice = buscaIndice(menuSesion.getVistaActual());
		}
		return indice != null ? indice : -1;
	}
	
}

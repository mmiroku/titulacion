package mx.upiicsa.titulacion.web.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuElemento {

	private String etiqueta;
	private String url;
	private List<MenuElemento> subMenu;
	private Map<String, String> propiedades;

	public MenuElemento() {
	}

	public MenuElemento(String etiqueta, String url, Map<String, String> propiedades) {
		this.etiqueta = etiqueta;
		this.url = url;
		this.propiedades = propiedades;
	}

	public MenuElemento agregarSubMenu(MenuElemento subMenu) {
		this.getSubMenu().add(subMenu);
		return this;
	}

	public MenuElemento agregarPropiedad(String llave, String valor) {
		this.getPropiedades().put(llave, valor);
		return this;
	}

	public boolean tieneSubMenu() {
		return subMenu != null && !subMenu.isEmpty();
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<MenuElemento> getSubMenu() {
		if (this.subMenu == null) {
			this.subMenu = new ArrayList<MenuElemento>();
		}
		return subMenu;
	}

	public void setSubMenu(List<MenuElemento> subMenu) {
		this.subMenu = subMenu;
	}

	public Map<String, String> getPropiedades() {
		if (this.propiedades == null) {
			this.propiedades = new HashMap<String, String>();
		}
		return propiedades;
	}

	public void setPropiedades(Map<String, String> propiedades) {
		this.propiedades = propiedades;
	}

}

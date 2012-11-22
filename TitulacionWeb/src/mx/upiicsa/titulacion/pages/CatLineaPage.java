package mx.upiicsa.titulacion.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import mx.upiicsa.titulacion.model.CatLinea;

@Named("pCatLinea")
@SessionScoped
public class CatLineaPage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private CatLinea catLinea = new CatLinea();
	
	private CatLinea filtro = new CatLinea(); 
	
	private List<CatLinea> catLineas = new ArrayList<CatLinea>();
	
	public void setCatLinea(CatLinea catLinea) {
		this.catLinea = catLinea;
	}
	
	public CatLinea getCatLinea() {
		return catLinea;
	}
	
	public void setCatLineas(List<CatLinea> catLineas) {
		this.catLineas = catLineas;
	}
	
	public List<CatLinea> getCatLineas() {
		return catLineas;
	}
	
	public void setFiltro(CatLinea filtro) {
		this.filtro = filtro;
	}
	
	public CatLinea getFiltro() {
		return filtro;
	}
		
}

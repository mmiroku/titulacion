package mx.upiicsa.titulacion.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import mx.upiicsa.titulacion.model.Maestro;

@Named("pMaestro")
@SessionScoped
public class MaestroPage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Maestro maestro = new Maestro();
	
	private Maestro filtro = new Maestro(); 
	
	private List<Maestro> maestros = new ArrayList<Maestro>();
	
	public void setMaestro(Maestro maestro) {
		this.maestro = maestro;
	}
	
	public Maestro getMaestro() {
		return maestro;
	}
	
	public void setMaestros(List<Maestro> maestros) {
		this.maestros = maestros;
	}
	
	public List<Maestro> getMaestros() {
		return maestros;
	}
	
	public void setFiltro(Maestro filtro) {
		this.filtro = filtro;
	}
	
	public Maestro getFiltro() {
		return filtro;
	}
		
}

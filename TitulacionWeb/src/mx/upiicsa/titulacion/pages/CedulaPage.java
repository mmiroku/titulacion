package mx.upiicsa.titulacion.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import mx.upiicsa.titulacion.model.Cedula;

@Named("pCedula")
@SessionScoped
public class CedulaPage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Cedula cedula = new Cedula();
	
	private Cedula filtro = new Cedula(); 
	
	private List<Cedula> cedulas = new ArrayList<Cedula>();
	
	public void setCedula(Cedula cedula) {
		this.cedula = cedula;
	}
	
	public Cedula getCedula() {
		return cedula;
	}
	
	public void setCedulas(List<Cedula> cedulas) {
		this.cedulas = cedulas;
	}
	
	public List<Cedula> getCedulas() {
		return cedulas;
	}
	
	public void setFiltro(Cedula filtro) {
		this.filtro = filtro;
	}
	
	public Cedula getFiltro() {
		return filtro;
	}
		
}

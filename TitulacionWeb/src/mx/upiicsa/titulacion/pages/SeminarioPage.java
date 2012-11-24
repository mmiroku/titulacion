package mx.upiicsa.titulacion.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import mx.upiicsa.titulacion.model.Alumno;
import mx.upiicsa.titulacion.model.Cedula;

import mx.upiicsa.titulacion.model.Seminario; 

@Named("pSeminario")
@SessionScoped
public class SeminarioPage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Seminario seminario = new Seminario();	
	private Seminario filtro = new Seminario();
	
	private List<Seminario> seminarios = new ArrayList<Seminario>();	
	
	private List<Alumno> pasantesSeleccionados = new ArrayList<Alumno>();
	
	private List<Cedula> expositoresSeleccionados = new ArrayList<Cedula>();
	
	
		
	public void setFiltro(Seminario filtro) {
		this.filtro = filtro;
	}
	
	public Seminario getFiltro() {
		return filtro;
	}
	
	public void setSeminario(Seminario seminario) {
		this.seminario = seminario;
	}
	
	public Seminario getSeminario() {
		return seminario;
	}
	
	public void setSeminarios(List<Seminario> seminarios) {
		this.seminarios = seminarios;
	}
	
	public List<Seminario> getSeminarios() {
		return seminarios;
	}
	
	public void setPasantesSeleccionados(List<Alumno> pasantesSeleccionados) {
		this.pasantesSeleccionados = pasantesSeleccionados;
	}
	
	public List<Alumno> getPasantesSeleccionados() {
		return pasantesSeleccionados;
	}
	
	public void setExpositoresSeleccionados(
			List<Cedula> expositoresSeleccionados) {
		this.expositoresSeleccionados = expositoresSeleccionados;
	}
	
	public List<Cedula> getExpositoresSeleccionados() {
		return expositoresSeleccionados;
	}
		
}

package mx.upiicsa.titulacion.pages;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import mx.upiicsa.titulacion.model.Academia;
import mx.upiicsa.titulacion.model.Carrera;
import mx.upiicsa.titulacion.model.CatLinea;
import mx.upiicsa.titulacion.model.CatSeminario;
import mx.upiicsa.titulacion.model.Cedula;
import mx.upiicsa.titulacion.model.Linea;
import mx.upiicsa.titulacion.model.Perfil;
import mx.upiicsa.titulacion.model.Sexo;

@Named("pCatalogo")
@SessionScoped
public class CatalogoPage implements Serializable {

	private static final long serialVersionUID = -1227563020949071674L;

	private List<Sexo> sexos;
	
	private List<Carrera> carreras;
	
	private List<Academia> academias;
	
	private List<Linea> lineas;
	
	private List<CatSeminario> catSeminarios;
	
	private List<Cedula> cedulas;
	
	private List<Perfil> perfiles;
	
	private List<CatLinea> catLineas;

	public List<Sexo> getSexos() {
		return sexos;
	}

	public void setSexos(List<Sexo> sexos) {
		this.sexos = sexos;
	}

	public List<Carrera> getCarreras() {
		return carreras;
	}

	public void setCarreras(List<Carrera> carreras) {
		this.carreras = carreras;
	}
	
	public List<Academia> getAcademias() {
		return academias;
	}
	
	public void setAcademias(List<Academia> academias) {
		this.academias = academias;
	}
	
	public void setLineas(List<Linea> lineas) {
		this.lineas = lineas;
	}
	
	public List<Linea> getLineas() {
		return lineas;
	}
	
	public void setCatSeminarios(List<CatSeminario> catSeminarios) {
		this.catSeminarios = catSeminarios;
	}
	
	public List<CatSeminario> getCatSeminarios() {
		return catSeminarios;
	}
	
	public void setCedulas(List<Cedula> cedulas) {
		this.cedulas = cedulas;
	}
	
	public List<Cedula> getCedulas() {
		return cedulas;
	}
	
	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}
	
	public List<Perfil> getPerfiles() {
		return perfiles;
	}
	
	public void setCatLineas(List<CatLinea> catLineas) {
		this.catLineas = catLineas;
	}
	
	public List<CatLinea> getCatLineas() {
		return catLineas;
	}
}

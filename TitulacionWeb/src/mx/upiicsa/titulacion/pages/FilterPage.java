package mx.upiicsa.titulacion.pages;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import mx.upiicsa.titulacion.model.Alumno;
import mx.upiicsa.titulacion.model.Cedula;

@Named("pFilter")
@SessionScoped
public class FilterPage implements Serializable {

	private static final long serialVersionUID = -7019327500972190121L;

	private List<Alumno> filteredAlumnos;
	
	private List<Cedula> filteredCedulas;

	public List<Alumno> getFilteredAlumnos() {
		return filteredAlumnos;
	}

	public void setFilteredAlumnos(List<Alumno> filteredAlumnos) {
		this.filteredAlumnos = filteredAlumnos;
	}
	
	public List<Cedula> getFilteredCedulas() {
		return filteredCedulas;
	}

	public void setFilteredCedulas(List<Cedula> filteredCedulas) {
		this.filteredCedulas = filteredCedulas;
	}
	
}

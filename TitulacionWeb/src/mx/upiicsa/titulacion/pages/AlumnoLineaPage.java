package mx.upiicsa.titulacion.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import mx.upiicsa.titulacion.model.AlumnoLinea;
import mx.upiicsa.titulacion.model.Materia;

@Named("pAlumnoLinea")
@SessionScoped
public class AlumnoLineaPage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private AlumnoLinea alumnoLinea = new AlumnoLinea();
	private AlumnoLinea filtro = new AlumnoLinea(); 	
	private List<AlumnoLinea> alumnoLineas = new ArrayList<AlumnoLinea>();
	
	private List<Materia> materiasSeleccionadas = new ArrayList<Materia>();
	
	public void setAlumnoLinea(AlumnoLinea alumnoLinea) {
		this.alumnoLinea = alumnoLinea;
	}
	
	public AlumnoLinea getAlumnoLinea() {
		return alumnoLinea;
	}
	
	public void setAlumnoLineas(List<AlumnoLinea> alumnoLineas) {
		this.alumnoLineas = alumnoLineas;
	}
	
	public List<AlumnoLinea> getAlumnoLineas() {
		return alumnoLineas;
	}
	
	public void setFiltro(AlumnoLinea filtro) {
		this.filtro = filtro;
	}
	
	public AlumnoLinea getFiltro() {
		return filtro;
	}
		
	public void setMateriasSeleccionadas(List<Materia> materiasSeleccionadas) {
		this.materiasSeleccionadas = materiasSeleccionadas;
	}
	
	public List<Materia> getMateriasSeleccionadas() {
		return materiasSeleccionadas;
	}
	
}

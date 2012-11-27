package mx.upiicsa.titulacion.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import mx.upiicsa.titulacion.model.AlumnoMateria; 

@Named("pAlumnoMateria")
@SessionScoped
public class AlumnoMateriaPage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private AlumnoMateria alumnoMateria = new AlumnoMateria();	
	private AlumnoMateria filtro = new AlumnoMateria();
		
	private List<AlumnoMateria> alumnoMaterias = new ArrayList<AlumnoMateria>();		
	
	public void setAlumnoMateria(AlumnoMateria alumnoMateria) {
		this.alumnoMateria = alumnoMateria;
	}
	
	public AlumnoMateria getAlumnoMateria() {
		return alumnoMateria;
	}
	
	public void setAlumnoMaterias(List<AlumnoMateria> alumnoMaterias) {
		this.alumnoMaterias = alumnoMaterias;
	}
	
	public List<AlumnoMateria> getAlumnoMaterias() {
		return alumnoMaterias;
	}
	
	public void setFiltro(AlumnoMateria filtro) {
		this.filtro = filtro;
	}
	
	public AlumnoMateria getFiltro() {
		return filtro;
	}
	
}

package mx.upiicsa.titulacion.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import mx.upiicsa.titulacion.model.Materia; 

@Named("pMateria")
@SessionScoped
public class MateriaPage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Materia materia = new Materia();	
	private Materia filtro = new Materia();
	
	private List<Materia> materias = new ArrayList<Materia>();
	
	public void setFiltro(Materia filtro) {
		this.filtro = filtro;
	}
	
	public Materia getFiltro() {
		return filtro;
	}
	
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	public Materia getMateria() {
		return materia;
	}
	
	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	
	public List<Materia> getMaterias() {
		return materias;
	}
	
}

package mx.upiicsa.titulacion.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import mx.upiicsa.titulacion.common.enums.Semestre;


@Entity
@NamedQueries({@NamedQuery(name = "Materia.findAll", query = "select m from Materia m"),
	// TODO Query con enum is null no funciona correctamente
@NamedQuery(name = "Materia.findByFilter", query = "select m from Materia m where ((:materia is null or :materia = '' ) or m.nombre = :materia) and m.semestre = :semestre and ((:idLinea is null or :idLinea = '') or m.linea.linea = :idLinea) and ((:idAcademia is null or :idAcademia = '') or m.academia.IdAcademia = :idAcademia)")})
@Table(name="TblMateria")

public class Materia implements Serializable {
	
	private static final long serialVersionUID = 8456149786853264552L;
	
	@Id
	@Column(name="IdMateria")
	private String idMateria;
	
	@JoinColumn(name="IdLinea")	
	private Linea linea;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="Semestre")
	private Semestre semestre;
	
	@Column(name="Descripcion")
	private String descripcion;
	
	@JoinColumn(name="IdAcademia")	
	private Academia academia;
	
	public Materia(){		
	}
	
	public void setAcademia(Academia academia) {
		this.academia = academia;
	}
	
	public Academia getAcademia() {
		return academia;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setIdMateria(String idMateria) {
		this.idMateria = idMateria;
	}
	
	public String getIdMateria() {
		return idMateria;
	}
	
	public void setLinea(Linea linea) {
		this.linea = linea;
	}
	
	public Linea getLinea() {
		return linea;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}
	
	public Semestre getSemestre() {
		return semestre;
	}
	
}

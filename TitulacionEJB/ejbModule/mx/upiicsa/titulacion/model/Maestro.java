package mx.upiicsa.titulacion.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@NamedQueries({
	@NamedQuery(name = "Maestro.findAll", query = "select m from Maestro m"),
	@NamedQuery(name = "Maestro.findByFilter", query = "select m from Maestro m where ((:abreviatura is null or :abreviatura = '' ) or m.Abreviatura = :abreviatura) and ((:nombre is null or :nombre = '') or m.nombre = :nombre) and ((:titulo is null or :titulo = '') or m.Titulo = :titulo) and ((:idAcademia is null or :idAcademia = '') or m.academia.IdAcademia = :idAcademia)") })
	
@Table(name="TblMaestro")
public class Maestro implements Serializable{
	
	private static final long serialVersionUID = 8456149786853264552L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdMaestro")
	private Long IdMaestro;
	
	@Column(name="ApellidoPaterno")
	private String aPaterno;
	
	@Column(name="ApellidoMaterno")
	private String aMaterno;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Titulo")
	private String Titulo;
	
	@Column(name="AnioIngreso")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date AnioIngreso;
	
	@JoinColumn(name="IdAcademia")	
	private Academia academia;
	
	@Column(name="Abreviatura")
	private String Abreviatura;	
	
	public Maestro() {
		//this.setAcademia(new Academia());
	}
			
	public void setAbreviatura(String abreviatura) {
		Abreviatura = abreviatura;
	}
	
	public String getAbreviatura() {
		return Abreviatura;
	}
	
	public void setAcademia(Academia academia) {
		this.academia = academia;
	}
	
	public Academia getAcademia() {
		return academia;
	}
	
	public void setaMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
	}
	
	public String getaMaterno() {
		return aMaterno;
	}
	
	public void setAnioIngreso(Date anioIngreso) {
		AnioIngreso = anioIngreso;
	}
	
	public Date getAnioIngreso() {
		return AnioIngreso;
	}
	
	public void setaPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}
	
	public String getaPaterno() {
		return aPaterno;
	}
	
	public void setIdMaestro(Long idMaestro) {
		IdMaestro = idMaestro;
	}
	
	public Long getIdMaestro() {
		return IdMaestro;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	
	public String getTitulo() {
		return Titulo;
	}	
}

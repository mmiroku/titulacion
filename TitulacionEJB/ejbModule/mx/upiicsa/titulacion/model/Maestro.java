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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Abreviatura == null) ? 0 : Abreviatura.hashCode());
		result = prime * result
				+ ((AnioIngreso == null) ? 0 : AnioIngreso.hashCode());
		result = prime * result
				+ ((IdMaestro == null) ? 0 : IdMaestro.hashCode());
		result = prime * result + ((Titulo == null) ? 0 : Titulo.hashCode());
		result = prime * result
				+ ((aMaterno == null) ? 0 : aMaterno.hashCode());
		result = prime * result
				+ ((aPaterno == null) ? 0 : aPaterno.hashCode());
		result = prime * result
				+ ((academia == null) ? 0 : academia.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Maestro other = (Maestro) obj;
		if (Abreviatura == null) {
			if (other.Abreviatura != null)
				return false;
		} else if (!Abreviatura.equals(other.Abreviatura))
			return false;
		if (AnioIngreso == null) {
			if (other.AnioIngreso != null)
				return false;
		} else if (!AnioIngreso.equals(other.AnioIngreso))
			return false;
		if (IdMaestro == null) {
			if (other.IdMaestro != null)
				return false;
		} else if (!IdMaestro.equals(other.IdMaestro))
			return false;
		if (Titulo == null) {
			if (other.Titulo != null)
				return false;
		} else if (!Titulo.equals(other.Titulo))
			return false;
		if (aMaterno == null) {
			if (other.aMaterno != null)
				return false;
		} else if (!aMaterno.equals(other.aMaterno))
			return false;
		if (aPaterno == null) {
			if (other.aPaterno != null)
				return false;
		} else if (!aPaterno.equals(other.aPaterno))
			return false;
		if (academia == null) {
			if (other.academia != null)
				return false;
		} else if (!academia.equals(other.academia))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}	
}

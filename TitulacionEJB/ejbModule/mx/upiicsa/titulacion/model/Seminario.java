package mx.upiicsa.titulacion.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name = "Seminario.findAll", query = "select s from Seminario s"),
	@NamedQuery(name = "Seminario.findByFilter", query = "select s from Seminario s where ((:seminario is null or :seminario = '' ) or s.catSeminario.idCatalogoSeminario = :seminario) and ((:cedula is null or :cedula = '') or s.cedula.numeroCedula = :cedula ) and ((:periodo is null or :periodo = '') or s.periodo like :periodo) and ((:sede is null or :sede = '') or s.sede = :sede)")})
	
@Table(name="TblSeminario")
public class Seminario implements Serializable{
	
	private static final long serialVersionUID = 8456149786853264552L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdSeminario")
	private int idSeminario;
	
	@JoinColumn(name="IdCatalogoSeminario")
	private CatSeminario catSeminario;
	
	@Column(name="Periodo")
	private String periodo;
	
	@Column(name="DiasHorario")
	private String diasHorario;
	
	@Column(name="Vigencia")
	private String vigencia;
	
	@Column(name="Sede")
	private String sede;
	
	@JoinColumn(name="Titular")
	private Cedula cedula;
	
	public Seminario() {
	}
	
	public void setCatSeminario(CatSeminario catSeminario) {
		this.catSeminario = catSeminario;
	}
	
	public CatSeminario getCatSeminario() {
		return catSeminario;
	}
	
	public void setDiasHorario(String diasHorario) {
		this.diasHorario = diasHorario;
	}
	
	public String getDiasHorario() {
		return diasHorario;
	}
	
	public void setIdSeminario(int idSeminario) {
		this.idSeminario = idSeminario;
	}
	
	public int getIdSeminario() {
		return idSeminario;
	}
	
	public void setCedula(Cedula cedula) {
		this.cedula = cedula;
	}
	
	public Cedula getCedula() {
		return cedula;
	}
	
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public String getPeriodo() {
		return periodo;
	}
	
	public void setSede(String sede) {
		this.sede = sede;
	}
	
	public String getSede() {
		return sede;
	}
	
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
	
	public String getVigencia() {
		return vigencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((catSeminario == null) ? 0 : catSeminario.hashCode());
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
		result = prime * result
				+ ((diasHorario == null) ? 0 : diasHorario.hashCode());
		result = prime * result + idSeminario;
		result = prime * result + ((periodo == null) ? 0 : periodo.hashCode());
		result = prime * result + ((sede == null) ? 0 : sede.hashCode());
		result = prime * result
				+ ((vigencia == null) ? 0 : vigencia.hashCode());
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
		Seminario other = (Seminario) obj;
		if (catSeminario == null) {
			if (other.catSeminario != null)
				return false;
		} else if (!catSeminario.equals(other.catSeminario))
			return false;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		if (diasHorario == null) {
			if (other.diasHorario != null)
				return false;
		} else if (!diasHorario.equals(other.diasHorario))
			return false;
		if (idSeminario != other.idSeminario)
			return false;
		if (periodo == null) {
			if (other.periodo != null)
				return false;
		} else if (!periodo.equals(other.periodo))
			return false;
		if (sede == null) {
			if (other.sede != null)
				return false;
		} else if (!sede.equals(other.sede))
			return false;
		if (vigencia == null) {
			if (other.vigencia != null)
				return false;
		} else if (!vigencia.equals(other.vigencia))
			return false;
		return true;
	}
		
}

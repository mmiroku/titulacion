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
		
}

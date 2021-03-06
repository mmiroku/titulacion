package mx.upiicsa.titulacion.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

@Entity
@NamedQueries({
	@NamedQuery(name = "Alumno.findAll", query = "select a from Alumno a"),
	@NamedQuery(name = "Alumno.findByFilter", query = "select a from Alumno a where ((:boleta is null or :boleta = '') or a.boleta = :boleta) and ((:nombre is null or :nombre = '') or a.nombre = :nombre) and ((:idCarrera is null or :idCarrera = 0) or a.carrera.idCarrera = :idCarrera) and ((:curp is null or :curp = '') or a.curp = :curp)") })
@Table(name="TblAlumno")
public class Alumno implements Serializable {

	private static final long serialVersionUID = 8456149786853264552L;

	@Id
	@Column(name="Boleta")
	private String boleta;
	
	@Column(name="ApellidoPaterno")
	private String aPaterno;
	
	@Column(name="ApellidoMaterno")
	private String aMaterno;
	
	@Column(name="Nombre")
	private String nombre;
	
	@JoinColumn(name="IdSexo")
	private Sexo sexo;
	
	@Column(name="RFC")
	private String rfc;
	
	@Column(name="Curp")
	private String curp;
	
	@Column(name="FechaNacimiento")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column(name="NumeroTelefono")
	private String numeroTelefono;
	
	@Column(name="NumeroCelular")
	private String numeroCelular;
	
	@Column(name="CorreoElectronico")
	private String email;
	
	@JoinColumn(name="IdDireccion")
	private Direccion direccion;
	
	@JoinColumn(name="IdCarrera")
	private Carrera carrera;
	
	@Column(name="InicioCarrera")
	private Integer inicioCarrera;
	
	@Column(name="FinCarrera")
	private Integer finCarrera;

	@Transient
	private Integer edad;
	
	public Alumno() {
		this.setDireccion(new Direccion());
	}

	public String getBoleta() {
		return boleta;
	}

	public void setBoleta(String boleta) {
		this.boleta = boleta;
	}

	public String getaPaterno() {
		return aPaterno;
	}

	public void setaPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}

	public String getaMaterno() {
		return aMaterno;
	}

	public void setaMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Integer getInicioCarrera() {
		return inicioCarrera;
	}

	public void setInicioCarrera(Integer inicioCarrera) {
		this.inicioCarrera = inicioCarrera;
	}

	public Integer getFinCarrera() {
		return finCarrera;
	}

	public void setFinCarrera(Integer finCarrera) {
		this.finCarrera = finCarrera;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

}

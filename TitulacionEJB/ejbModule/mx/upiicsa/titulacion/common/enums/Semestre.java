package mx.upiicsa.titulacion.common.enums;

public enum Semestre {

	PRIMERO(1, "data.semestre.primero"),
	SEGUNDO(2, "data.semestre.segundo"),
	TERCERO(3, "data.semestre.tercero"),
	CUARTO(4, "data.semestre.cuarto"),
	QUINTO(5, "data.semestre.quinto"),
	SEXTO(6, "data.semestre.sexto"),
	SEPTIMO(7, "data.semestre.septimo"),
	OCTAVO(8, "data.semestre.octavo");

	private Integer id;

	private String etiqueta;

	private Semestre(Integer id, String etiqueta) {
		this.id = id;
		this.etiqueta = etiqueta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

}

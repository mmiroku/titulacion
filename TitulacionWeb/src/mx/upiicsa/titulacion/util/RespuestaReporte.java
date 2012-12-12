package mx.upiicsa.titulacion.util;

import java.io.Serializable;


/**
 * Clase que contiene los datos del reporte que se generar en Excel o en PDF.
 */
public class RespuestaReporte implements Serializable {

	/** Serial Version UID de la clase. */
	private static final long serialVersionUID = 5142226008199908190L;

	/** Nombre del archivo que se genera. */
	private String nombreArchivo;
	
	/** Archivo binario generado. */
	private byte[] archivo;
	
	/** Tipo de reporte generado PDF EXCEL. */
	private Integer tipoReporte;

	/**
	 * M&eacute;todo que obtiene el valor de nombreArchivo.
	 * 
	 * @return El valor de nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	/**
	 * M&eacute;todo que establece el valor de nombreArchivo.
	 * 
	 * @param nombreArchivo
	 *            El valor a establecer en nombreArchivo
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	/**
	 * M&eacute;todo que obtiene el valor de archivo.
	 * 
	 * @return El valor de archivo
	 */
	public byte[] getArchivo() {
		return archivo.clone();
	}

	/**
	 * M&eacute;todo que establece el valor de archivo.
	 * 
	 * @param archivo
	 *            El valor a establecer en archivo
	 */
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo.clone();
	}

	/**
	 * M&eacute;todo que obtiene el valor de tipoReporte.
	 * 
	 * @return El valor de tipoReporte
	 */
	public Integer getTipoReporte() {
		return tipoReporte;
	}

	/**
	 * M&eacute;todo que establece el valor de tipoReporte.
	 * 
	 * @param tipoReporte
	 *            El valor a establecer en tipoReporte
	 */
	public void setTipoReporte(Integer tipoReporte) {
		this.tipoReporte = tipoReporte;
	}
	
}

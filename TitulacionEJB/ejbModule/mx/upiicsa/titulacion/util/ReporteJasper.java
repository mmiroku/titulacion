package mx.upiicsa.titulacion.util;

import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.upiicsa.titulacion.common.constantes.ConstantesRBReportes;
import mx.upiicsa.titulacion.common.constantes.ConstantesReportes;
import mx.upiicsa.titulacion.common.constantes.Constants;
import mx.upiicsa.titulacion.exceptions.TitulacionException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * Esta clase se encarga de generar, a trav&eacute;s de Jasper Reports, reportes
 * en PDF. Los archivos generados se regresan com un arreglo de bytes.
 */
public class ReporteJasper{
    
	/** Nombre del reporte de la plantilla hecha en Jasper Reports. */
    private String nombreReporte;
    
    /** Colecci�n de datos para desplegar en el reporte. */
    private List dataSource;
    
    /** Mapa de par�metros para desplegar en el reporte. */
    private Map<String, Object> parametros;
       
    /**
	 * Constructor de la case.
	 * 
	 * @param nombreReporte
	 *            El nombre calificado completo del reporte (Ej.
	 *            /mx/com/ids/Reporte.jasper)
	 * @param parametros
	 *            Los par�metros que han de pasar al reporte
	 * @param dataSource
	 *            La colecci�n que ser� el Data Source del reporte
	 */
    public ReporteJasper(
            String nombreReporte,
            Map<String, Object> parametros,
            List dataSource){
        this.nombreReporte = nombreReporte;
        this.parametros = parametros;
        if(null == parametros) {
        	this.parametros = new HashMap<String, Object>();
        }
        this.parametros.put(
        		ConstantesReportes.PARAMETROS_RESOURCE_BUNDLE, 
        		ConstantesRBReportes.LABELS);
        this.parametros.put(
        		ConstantesReportes.PARAMETRO_LOCALE,
        		Constants.LOCALE_ES_MX);  
        String urlLogo = ReporteJasper.class.getResource(ConstantesReportes.REPORTE_IMAGEN_LOGO).toString();
        parametros.put(ConstantesReportes.PARAMETROS_LOGO, urlLogo);
        this.dataSource = dataSource;
    }
       
    /**
	 * Este m&eacute;todo genera un reporte en PDF.
	 * 
	 * @return byte[] (Reporte PDF)
	 * @throws CotizadorException
	 *             el med cls med exception
	 */
    public byte[] generarReportePdf() 
    throws TitulacionException{
        
    	try {
    		JasperPrint jasperPrint = generarJasperPrint();
        
    		return JasperExportManager.exportReportToPdf(jasperPrint);
    	} catch (JRException e) {
			throw new TitulacionException(e.getMessage(), e);
		}
    }
    
    /**
	 * Este m&eacute;todo genera un reporte PDF y lo guarda en el sistema de
	 * archivos.
	 * 
	 * @param rutaDestino
	 *            el ruta destino
	 * @throws CotizadorException
	 *             el med cls med exception
	 */
    public void guardaPdfEnSistArch( String rutaDestino ) throws TitulacionException{
    	
    	try {
    		JasperPrint jasperPrint = generarJasperPrint();
    		JasperExportManager.exportReportToPdfFile(jasperPrint,rutaDestino);
    	} catch(JRException e) {
    		throw new TitulacionException(e.getMessage(), e);
    	}
    } 
    
    /**
	 * Este reporte genera un objeto <code>JasperPrint</code> a partir del cual
	 * se genera un reporte Jasper y del que se puede exportar a diferentes
	 * formatos.
	 * 
	 * @return jasper print
	 * @throws CotizadorException
	 *             el med cls med exception
	 */
    private JasperPrint generarJasperPrint() 
    throws TitulacionException {
    	
    	try {
	    
	        URL jasper = ReporteJasper.class.getResource(nombreReporte);
	        JasperReport jasperReport = (JasperReport)JRLoader.loadObject(jasper);
	        
	        return JasperFillManager.fillReport(
	                jasperReport, 
	                parametros, 
	                new JRBeanCollectionDataSource(dataSource));
    	} catch(JRException e) {
    		throw new TitulacionException(e.getMessage(), e);
	}
    }
    
    /**
	 * Agrega objetos a un mapa de nombre Parametros.
	 * 
	 * @param llave
	 *            el llave
	 * @param valor
	 *            el valor
	 */
    public void agregarParametro(String llave,Object valor){
        if(null == parametros) {
            parametros = new HashMap<String, Object>();
        }
        parametros.put(llave,valor);
    }
    
    /**
	 * Remueve de un mapa un objeto.
	 * 
	 * @param llave
	 *            el llave
	 */
    public void eliminarParametro(String llave){
        parametros.remove(llave);
    }

	/**
	 * M&eacute;todo que obtiene el valor de nombreReporte.
	 * 
	 * @return El valor de nombreReporte
	 */
	public String getNombreReporte() {
		return nombreReporte;
	}

	/**
	 * M&eacute;todo que establece el valor de nombreReporte.
	 * 
	 * @param nombreReporte
	 *            El valor a establecer en nombreReporte
	 */
	public void setNombreReporte(String nombreReporte) {
		this.nombreReporte = nombreReporte;
	}

	/**
	 * M&eacute;todo que obtiene el valor de dataSource.
	 * 
	 * @return El valor de dataSource
	 */
	public Collection<Object> getDataSource() {
		return dataSource;
	}

	/**
	 * M&eacute;todo que establece el valor de dataSource.
	 * 
	 * @param dataSource
	 *            El valor a establecer en dataSource
	 */
	public void setDataSource(List dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * M&eacute;todo que establece el valor de parametros.
	 * 
	 * @param parametros
	 *            El valor a establecer en parametros
	 */
	public void setParametros(Map<String, Object> parametros) {
		this.parametros = parametros;
	}
    
}
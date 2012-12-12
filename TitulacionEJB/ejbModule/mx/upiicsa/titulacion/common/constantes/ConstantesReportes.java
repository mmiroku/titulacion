package mx.upiicsa.titulacion.common.constantes;

public class ConstantesReportes {

    /** La constante REPORTE_BASE_FOLDER. */
    public static final String REPORTE_BASE_FOLDER = "reports";

    /** La constante REPORTE_TEMPLATE_FOLDER. */
    public static final String REPORTE_TEMPLATE_FOLDER = "templates";

    /** La constante REPORTE_PROPERTIES_FOLDER. */
    public static final String REPORTE_PROPERTIES_FOLDER = "properties";
    
    /** La constante REPORTE_IMAGE_FOLDER. */
    public static final String REPORTE_IMAGE_FOLDER = "images";

    /** La constante REPORT_RESOURCE_BUNDLE_LABELS. */
    public static final String REPORT_RESOURCE_BUNDLE_LABELS = REPORTE_BASE_FOLDER
	    + "." + REPORTE_PROPERTIES_FOLDER + "." + "report_labels";

    /** La constante REPORTE_ACTA_PDF. */
    public static final String REPORTE_ACTA_PDF = "/" + REPORTE_BASE_FOLDER
    		+ "/" + REPORTE_TEMPLATE_FOLDER + "/" + "Acta.jasper";
    
    /** La constante REPORTE_IMAGEN_LOGO. */
    public static final String REPORTE_IMAGEN_LOGO = "/" + REPORTE_BASE_FOLDER
														+ "/" + REPORTE_IMAGE_FOLDER + "/" + "ipn.jpg";

    /** La constante PARAMETROS_RESOURCE_BUNDLE. */
    public static final String PARAMETROS_RESOURCE_BUNDLE = "REPORT_RESOURCE_BUNDLE";

    /** La constante PARAMETRO_LOCALE. */
    public static final String PARAMETRO_LOCALE = "REPORT_LOCALE";
    
    /** La constante PARAMETROS_LOGO. */
    public static final String PARAMETROS_LOGO = "LOGO";
    
}

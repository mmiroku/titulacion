package mx.upiicsa.titulacion.util;

import java.util.Map;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public final class JSFUtils {
	
	// TODO
	public static String getUsuarioSessionID() {
		return ((String) getSessionMap().get(WConstants.USUARIO_WEBOBJECT)); //.getSessionID();
	}

	public static String getUsuarioFirmado() {
		return (String) getSessionMap().get(WConstants.USUARIO_WEBOBJECT);
	}

	/**
	 * Regresa la Instancia de la actual Aplicacion JSF
	 * 
	 * @return La objeto <code>Application</code>
	 */
	public static Application getApplication() {
		return getFacesContext().getApplication();
	}

	/**
	 * Regresa un Map de los atributos de la aplicacion para esta aplicacion
	 * web.
	 * 
	 * @return El objeto <code>Map</code> con los atributos de la
	 *         aplicaci&oacute;n.
	 */
	public static Map<?, ?> getApplicationMap() {
		return getExternalContext().getApplicationMap();
	}

	/**
	 * Regresa la instancia del <code>ExternalContext</code> para esta peticion.
	 * 
	 * @return El objecto <code>ExternalContext</code>
	 */
	public static ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}

	/**
	 * Regresa la Instancia <code>FacesContext</code> de la actual peticion
	 * 
	 * @return el objecto <code>FacesContext</code>
	 */
	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	/**
	 * Regresa un Map de los atributos de la petici&oacute;n actual.
	 * 
	 * @return El objeto <code>Map</code> con los atributos de la
	 *         petici&oacute;n.
	 */
	public static Map<?, ?> getRequestMap() {
		return getExternalContext().getRequestMap();
	}

	/**
	 * Regresa un Map de los parametros de la petici&oacute;n actual.
	 * 
	 * @return El objeto <code>Map</code> con los parametros de la
	 *         petici&oacute;n.
	 */
	public static Map<?, ?> getParameterMap() {
		return getExternalContext().getRequestParameterMap();
	}

	/**
	 * Regresa un Map de los atributos de la session del usuario.
	 * 
	 * @return El objeto <code>Map</code> con los atributos de la session.
	 */
	public static Map<?, ?> getSessionMap() {
		return getExternalContext().getSessionMap();
	}

	/**
	 * Agrega un mensaje a un componente especifico en la vista a mostrar.
	 * 
	 * @param componentID
	 *            El ID del componente.
	 * @param messageID
	 *            El ID del mensaje que se va a mostrar, debe de encontrarse en
	 *            el archivo ResourceBundle configurado en face-config.xml
	 * @param severity
	 *            Tipo de mensaje
	 */
	public static void messageByIDComponent(String componentID, String messageID, Severity severity) {

		FacesMessage facesMessage = Messages.getMessage(messageID, null);
		facesMessage.setSeverity(severity);

		getFacesContext().addMessage(WConstants.FORM_NAME + componentID, facesMessage);

	}
	public static void messageGlobal(String messageID, Severity severity) {

		FacesMessage facesMessage = Messages.getMessage(messageID, null);
		facesMessage.setSeverity(severity);

		getFacesContext().addMessage(null,facesMessage);

	}

	/**
	 * Agrega un mensaje a un componente especifico en la vista a mostrar.
	 * 
	 * @param componentID
	 *            El ID del componente.
	 * @param severity
	 *            Tipo de mensaje
	 * @param summary
	 *            El texto que va a ser mostrado en pantalla
	 */
	public static void messageByIDComponent(String componentID, Severity severity, String summary) {

		getFacesContext().addMessage(WConstants.FORM_NAME + componentID, new FacesMessage(severity, summary, null));

	}
	public static void messageGlobal(Severity severity, String summary) {

		getFacesContext().addMessage(null, new FacesMessage(severity, summary, null));

	}

	/**
	 * Agrega un mensaje a un componente especifico en la vista a mostrar.
	 * 
	 * @param componentID
	 *            El ID del componente.
	 * @param messageID
	 *            El ID del mensaje que se va a mostrar.
	 * @param params
	 *            Parametros para construir el mensaje.
	 * @param severity
	 *            Tipo de mensaje
	 */
	public static void messageByIDComponent(String componentID, String messageID, Object[] params, Severity severity) {

		FacesMessage facesMessage = Messages.getMessage(messageID, params);
		facesMessage.setSeverity(severity);

		getFacesContext().addMessage(WConstants.FORM_NAME + componentID, facesMessage);

	}
	public static void messageGlobal( String messageID, Object[] params, Severity severity) {

		FacesMessage facesMessage = Messages.getMessage(messageID, params);
		facesMessage.setSeverity(severity);

		getFacesContext().addMessage(null, facesMessage);

	}
}

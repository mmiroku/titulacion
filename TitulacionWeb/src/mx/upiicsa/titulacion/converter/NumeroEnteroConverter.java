package mx.upiicsa.titulacion.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mx.upiicsa.titulacion.common.constantes.ClavesMensajes;
import mx.upiicsa.titulacion.util.Messages;

@FacesConverter(value = "NumeroEnteroConverter", forClass = Integer.class)
public class NumeroEnteroConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component,
			String newValue) throws ConverterException {
		Integer numero = null;
		if (newValue != null && !newValue.equals("")) {
			StringBuilder builder = new StringBuilder(newValue);
			for (int i = 0; i < newValue.length(); i++) {
				if (Character.isDigit(builder.charAt(i)) == false) {
					FacesMessage facesMessage = Messages.getMessage(
							ClavesMensajes.MESSAGE_EXCEPTION_INTEGER, new Object[] { component.getAttributes().get("label") });
					facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
					throw new ConverterException(facesMessage);
				}
			}
			numero = Integer.valueOf(newValue);
		}
		return numero;
	}

	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object object) {
		Integer numero = (Integer) object;
		if (numero == null) {
			return "";
		} else {
			return numero.toString();
		}
	}

}

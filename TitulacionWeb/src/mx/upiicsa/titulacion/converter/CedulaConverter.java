package mx.upiicsa.titulacion.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mx.upiicsa.titulacion.model.Cedula;

@FacesConverter(value = "CedulaConverter", forClass = Cedula.class)
public class CedulaConverter implements Converter{
	/** La constante LOG. */

	public Object getAsObject(FacesContext context, UIComponent component,
			String newValue) throws ConverterException {
		return getObjectFromSelectComponent(component, newValue);
	}

	@SuppressWarnings("unchecked")
	private Object getObjectFromSelectComponent(UIComponent component,
			String newValue) {
		final List<Cedula> cedulaList;
		try {
			cedulaList = (List<Cedula>) ((UISelectItems) component
					.getChildren().get(component.getChildren().size() - 1))
					.getValue();
			Cedula cedula = getObjectFromList(cedulaList,
					newValue);
			return cedula;
		} catch (ClassCastException cce) {
			//LOG.error("ClassCastException");
			throw new ConverterException(cce);
		} catch (NumberFormatException nfe) {
			//LOG.error("NumberFormatException");
			throw new ConverterException(nfe);
		}
	}

	private Cedula getObjectFromList(final List<?> list,
			final String identifier) {
		for (final Object object : list) {
			final Cedula cedula = (Cedula) object;
			if (cedula.getNumeroCedula().equals(identifier)) {
				return cedula;
			}
		}
		return null;
	}

	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object object) {
		String string;
		if (object == null) {
			string = "";
		} else {
			try {
				string = String.valueOf(((Cedula) object).getNumeroCedula());
			} catch (ClassCastException cce) {
				//LOG.error("ClassCastException");				
				throw new ConverterException(cce);				
			}
		}
		return string;
	}
}

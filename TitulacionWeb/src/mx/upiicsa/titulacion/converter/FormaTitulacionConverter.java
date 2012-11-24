package mx.upiicsa.titulacion.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mx.upiicsa.titulacion.model.FormaTitulacion;

@FacesConverter(value = "FormaTitulacionConverter", forClass = FormaTitulacion.class)
public class FormaTitulacionConverter implements Converter {
	/** La constante LOG. */
    //private final static Log LOG = LogFactory.getLog(formaTitulacionConverter.class);

	public Object getAsObject(FacesContext context, UIComponent component,
			String newValue) throws ConverterException {
		return getObjectFromSelectComponent(component, newValue);
	}

	@SuppressWarnings("unchecked")
	private Object getObjectFromSelectComponent(UIComponent component,
			String newValue) {
		final List<FormaTitulacion> formaTitulacionList;
		try {
			formaTitulacionList = (List<FormaTitulacion>) ((UISelectItems) component
					.getChildren().get(component.getChildren().size() - 1))
					.getValue();
			FormaTitulacion formaTitulacion = getObjectFromList(formaTitulacionList,
					Integer.valueOf(newValue));
			return formaTitulacion;
		} catch (ClassCastException cce) {
			//LOG.error("ClassCastException");
			throw new ConverterException(cce);
		} catch (NumberFormatException nfe) {
			//LOG.error("NumberFormatException");
			throw new ConverterException(nfe);
		}
	}

	private FormaTitulacion getObjectFromList(final List<?> list,
			final int identifier) {
		for (final Object object : list) {
			final FormaTitulacion formaTitulacion = (FormaTitulacion) object;
			if (formaTitulacion.getIdFormaTitulacion() == identifier) {
				return formaTitulacion;
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
				string = String.valueOf(((FormaTitulacion) object).getIdFormaTitulacion());
			} catch (ClassCastException cce) {
				//LOG.error("ClassCastException");
				throw new ConverterException(cce);
			}
		}
		return string;
	}
}

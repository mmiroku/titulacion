package mx.upiicsa.titulacion.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mx.upiicsa.titulacion.model.Carrera;

@FacesConverter(value = "CarreraConverter", forClass = Carrera.class)
public class CarreraConverter implements Converter {
	/** La constante LOG. */
    //private final static Log LOG = LogFactory.getLog(carreraConverter.class);

	public Object getAsObject(FacesContext context, UIComponent component,
			String newValue) throws ConverterException {
		return getObjectFromSelectComponent(component, newValue);
	}

	@SuppressWarnings("unchecked")
	private Object getObjectFromSelectComponent(UIComponent component,
			String newValue) {
		final List<Carrera> carreraList;
		try {
			carreraList = (List<Carrera>) ((UISelectItems) component
					.getChildren().get(component.getChildren().size() - 1))
					.getValue();
			Carrera carrera = getObjectFromList(carreraList,
					Integer.valueOf(newValue));
			return carrera;
		} catch (ClassCastException cce) {
			//LOG.error("ClassCastException");
			throw new ConverterException(cce);
		} catch (NumberFormatException nfe) {
			//LOG.error("NumberFormatException");
			throw new ConverterException(nfe);
		}
	}

	private Carrera getObjectFromList(final List<?> list,
			final int identifier) {
		for (final Object object : list) {
			final Carrera carrera = (Carrera) object;
			if (carrera.getIdCarrera() == identifier) {
				return carrera;
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
				string = String.valueOf(((Carrera) object).getIdCarrera());
			} catch (ClassCastException cce) {
				//LOG.error("ClassCastException");
				throw new ConverterException(cce);
			}
		}
		return string;
	}
}

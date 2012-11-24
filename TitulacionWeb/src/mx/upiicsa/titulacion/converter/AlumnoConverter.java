package mx.upiicsa.titulacion.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mx.upiicsa.titulacion.model.Alumno;

@FacesConverter(value = "AlumnoConverter", forClass = Alumno.class)
public class AlumnoConverter implements Converter{
	/** La constante LOG. */
    //private final static Log LOG = LogFactory.getLog(carreraConverter.class);

	public Object getAsObject(FacesContext context, UIComponent component,
			String newValue) throws ConverterException {
		return getObjectFromSelectComponent(component, newValue);
	}

	@SuppressWarnings("unchecked")
	private Object getObjectFromSelectComponent(UIComponent component,
			String newValue) {
		final List<Alumno> alumnoList;
		try {
			alumnoList = (List<Alumno>) ((UISelectItems) component
					.getChildren().get(component.getChildren().size() - 1))
					.getValue();
			Alumno alumno = getObjectFromList(alumnoList,
					newValue);
			return alumno;
		} catch (ClassCastException cce) {
			//LOG.error("ClassCastException");
			throw new ConverterException(cce);
		} catch (NumberFormatException nfe) {
			//LOG.error("NumberFormatException");
			throw new ConverterException(nfe);
		}
	}

	private Alumno getObjectFromList(final List<?> list,
			final String identifier) {
		for (final Object object : list) {
			final Alumno alumno = (Alumno) object;
			if (alumno.getBoleta().equals(identifier)) {
				return alumno;
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
				string = String.valueOf(((Alumno) object).getBoleta());
			} catch (ClassCastException cce) {
				//LOG.error("ClassCastException");
				throw new ConverterException(cce);
			}
		}
		return string;
	}
}

package mx.upiicsa.titulacion.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mx.upiicsa.titulacion.model.Proyecto;

@FacesConverter(value = "ProyectoConverter", forClass = Proyecto.class)
public class ProyectoConverter implements Converter{
	/** La constante LOG. */
    //private final static Log LOG = LogFactory.getLog(carreraConverter.class);

	public Object getAsObject(FacesContext context, UIComponent component,
			String newValue) throws ConverterException {
		return getObjectFromSelectComponent(component, newValue);
	}

	@SuppressWarnings("unchecked")
	private Object getObjectFromSelectComponent(UIComponent component,
			String newValue) {
		final List<Proyecto> proyectoList;
		try {
			proyectoList = (List<Proyecto>) ((UISelectItems) component
					.getChildren().get(component.getChildren().size() - 1))
					.getValue();
			Proyecto proyecto = getObjectFromList(proyectoList,
					Integer.valueOf(newValue));
			return proyecto;
		} catch (ClassCastException cce) {
			//LOG.error("ClassCastException");
			throw new ConverterException(cce);
		} catch (NumberFormatException nfe) {
			//LOG.error("NumberFormatException");
			throw new ConverterException(nfe);
		}
	}

	private Proyecto getObjectFromList(final List<?> list,
			final int identifier) {
		for (final Object object : list) {
			final Proyecto proyecto = (Proyecto) object;
			if (proyecto.getIdProyecto() == identifier) {
				return proyecto;
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
				string = String.valueOf(((Proyecto) object).getIdProyecto());
			} catch (ClassCastException cce) {
				//LOG.error("ClassCastException");
				throw new ConverterException(cce);
			}
		}
		return string;
	}
}

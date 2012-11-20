package mx.upiicsa.titulacion.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mx.upiicsa.titulacion.model.Perfil;

@FacesConverter(value = "PerfilConverter", forClass = Perfil.class)
public class PerfilConverter implements Converter {
	/** La constante LOG. */


	public Object getAsObject(FacesContext context, UIComponent component,
			String newValue) throws ConverterException {
		return getObjectFromSelectComponent(component, newValue);
	}

	@SuppressWarnings("unchecked")
	private Object getObjectFromSelectComponent(UIComponent component,
			String newValue) {
		final List<Perfil> perfilList;
		try {
			perfilList = (List<Perfil>) ((UISelectItems) component
					.getChildren().get(component.getChildren().size() - 1))
					.getValue();
			Perfil perfil = getObjectFromList(perfilList,
					Integer.valueOf(newValue));
			return perfil;
		} catch (ClassCastException cce) {
			//LOG.error("ClassCastException");
			throw new ConverterException(cce);
		} catch (NumberFormatException nfe) {
			//LOG.error("NumberFormatException");
			throw new ConverterException(nfe);
		}
	}

	private Perfil getObjectFromList(final List<?> list,
			final int identifier) {
		for (final Object object : list) {
			final Perfil perfil = (Perfil) object;
			if (perfil.getIdPerfil() == identifier) {
				return perfil;
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
				string = String.valueOf(((Perfil) object).getIdPerfil());
			} catch (ClassCastException cce) {
				//LOG.error("ClassCastException");
				throw new ConverterException(cce);
			}
		}
		return string;
	}
}

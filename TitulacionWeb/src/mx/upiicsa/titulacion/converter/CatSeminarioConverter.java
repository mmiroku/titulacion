package mx.upiicsa.titulacion.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mx.upiicsa.titulacion.model.CatSeminario;

@FacesConverter(value = "CatSeminarioConverter", forClass = CatSeminario.class)
public class CatSeminarioConverter implements Converter{
	/** La constante LOG. */

	public Object getAsObject(FacesContext context, UIComponent component,
			String newValue) throws ConverterException {
		return getObjectFromSelectComponent(component, newValue);
	}

	@SuppressWarnings("unchecked")
	private Object getObjectFromSelectComponent(UIComponent component,
			String newValue) {
		final List<CatSeminario> catSeminarioList;
		try {
			catSeminarioList = (List<CatSeminario>) ((UISelectItems) component
					.getChildren().get(component.getChildren().size() - 1))
					.getValue();
			CatSeminario catSeminario = getObjectFromList(catSeminarioList,
					Integer.valueOf(newValue));
			return catSeminario;
		} catch (ClassCastException cce) {
			//LOG.error("ClassCastException");
			throw new ConverterException(cce);
		} catch (NumberFormatException nfe) {
			//LOG.error("NumberFormatException");
			throw new ConverterException(nfe);
		}
	}

	private CatSeminario getObjectFromList(final List<?> list,
			final int identifier) {
		for (final Object object : list) {
			final CatSeminario catSeminario = (CatSeminario) object;
			if (catSeminario.getIdCatalogoSeminario() == identifier) {
				return catSeminario;
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
				string = String.valueOf(((CatSeminario) object).getIdCatalogoSeminario());
			} catch (ClassCastException cce) {
				//LOG.error("ClassCastException");
				throw new ConverterException(cce);
			}
		}
		return string;
	}
}

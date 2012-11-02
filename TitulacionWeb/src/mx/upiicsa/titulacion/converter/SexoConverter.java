package mx.upiicsa.titulacion.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mx.upiicsa.titulacion.model.Sexo;

@FacesConverter(value = "SexoConverter", forClass = Sexo.class)
public class SexoConverter implements Converter {
	/** La constante LOG. */
    //private final static Log LOG = LogFactory.getLog(sexoConverter.class);

	public Object getAsObject(FacesContext context, UIComponent component,
			String newValue) throws ConverterException {
		return getObjectFromSelectComponent(component, newValue);
	}

	@SuppressWarnings("unchecked")
	private Object getObjectFromSelectComponent(UIComponent component,
			String newValue) {
		final List<Sexo> sexoList;
		try {
			sexoList = (List<Sexo>) ((UISelectItems) component
					.getChildren().get(component.getChildren().size() - 1))
					.getValue();
			Sexo sexo = getObjectFromList(sexoList,
					Integer.valueOf(newValue));
			return sexo;
		} catch (ClassCastException cce) {
			//LOG.error("ClassCastException");
			throw new ConverterException(cce);
		} catch (NumberFormatException nfe) {
			//LOG.error("NumberFormatException");
			throw new ConverterException(nfe);
		}
	}

	private Sexo getObjectFromList(final List<?> list,
			final int identifier) {
		for (final Object object : list) {
			final Sexo sexo = (Sexo) object;
			if (sexo.getIdSexo() == identifier) {
				return sexo;
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
				string = String.valueOf(((Sexo) object).getIdSexo());
			} catch (ClassCastException cce) {
				//LOG.error("ClassCastException");
				throw new ConverterException(cce);
			}
		}
		return string;
	}
}

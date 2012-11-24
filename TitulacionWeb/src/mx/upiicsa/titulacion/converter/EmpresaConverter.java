package mx.upiicsa.titulacion.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import mx.upiicsa.titulacion.model.Empresa;

@FacesConverter(value = "EmpresaConverter", forClass = Empresa.class)
public class EmpresaConverter implements Converter{
	/** La constante LOG. */
    //private final static Log LOG = LogFactory.getLog(carreraConverter.class);

	public Object getAsObject(FacesContext context, UIComponent component,
			String newValue) throws ConverterException {
		return getObjectFromSelectComponent(component, newValue);
	}

	@SuppressWarnings("unchecked")
	private Object getObjectFromSelectComponent(UIComponent component,
			String newValue) {
		final List<Empresa> empresaList;
		try {
			empresaList = (List<Empresa>) ((UISelectItems) component
					.getChildren().get(component.getChildren().size() - 1))
					.getValue();
			Empresa empresa = getObjectFromList(empresaList,
					newValue);
			return empresa;
		} catch (ClassCastException cce) {
			//LOG.error("ClassCastException");
			throw new ConverterException(cce);
		} catch (NumberFormatException nfe) {
			//LOG.error("NumberFormatException");
			throw new ConverterException(nfe);
		}
	}

	private Empresa getObjectFromList(final List<?> list,
			final String identifier) {
		for (final Object object : list) {
			final Empresa empresa = (Empresa) object;
			if (empresa.getRfc().equals(identifier)) {
				return empresa;
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
				string = String.valueOf(((Empresa) object).getRfc());
			} catch (ClassCastException cce) {
				//LOG.error("ClassCastException");
				throw new ConverterException(cce);
			}
		}
		return string;
	}
}

package br.gov.rj.mis.util.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.omnifaces.converter.SelectItemsConverter;

import br.gov.rj.mis.model.TipoDocumental;

@FacesConverter(forClass = TipoDocumental.class)
public class TipoDocumentalConverter extends SelectItemsConverter {

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		TipoDocumental tipoDoc = (TipoDocumental) value;
		return String.valueOf(tipoDoc.getId());
	}
}

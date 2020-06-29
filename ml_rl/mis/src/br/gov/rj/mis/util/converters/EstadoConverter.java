package br.gov.rj.mis.util.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.omnifaces.converter.SelectItemsConverter;

import br.gov.rj.mis.model.Estado;

@FacesConverter(forClass = Estado.class)
public class EstadoConverter extends SelectItemsConverter {
	
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Estado estado = (Estado)value;
		return String.valueOf(estado.getId());
	}

}

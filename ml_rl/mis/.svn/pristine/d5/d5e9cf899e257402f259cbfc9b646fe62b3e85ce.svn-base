package br.gov.rj.mis.util.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.omnifaces.converter.SelectItemsConverter;

import br.gov.rj.mis.model.Setor;

@FacesConverter(forClass = Setor.class)
public class SetorConverter extends SelectItemsConverter {
	
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Setor setor = (Setor)value;
		return String.valueOf(setor.getId());
	}

}

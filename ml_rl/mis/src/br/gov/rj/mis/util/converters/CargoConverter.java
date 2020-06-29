package br.gov.rj.mis.util.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.omnifaces.converter.SelectItemsConverter;

import br.gov.rj.mis.model.Cargo;

@FacesConverter(forClass = Cargo.class)
public class CargoConverter extends SelectItemsConverter {
	
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Cargo cargo = (Cargo)value;
		return String.valueOf(cargo.getId());
	}

}

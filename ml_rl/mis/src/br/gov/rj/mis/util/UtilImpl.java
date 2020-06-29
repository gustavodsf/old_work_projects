package br.gov.rj.mis.util;

import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class UtilImpl {
	private UtilImpl(){
		
	}
	
	public static ResourceBundle getMessageBundle(){
		ResourceBundle messaBundle = ResourceBundle.getBundle("resources.messages",FacesContext.getCurrentInstance().getViewRoot().getLocale());
		return messaBundle;
	}
}

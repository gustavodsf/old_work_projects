package br.gov.rj.mis.view;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.jboss.security.SecurityAssociation;


@ManagedBean(name="authenticator")
public class AuthenticatorManagedBean {

	public void logOut(){
		FacesContext fc = FacesContext.getCurrentInstance();  
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);  
		session.invalidate();
		SecurityAssociation.clear();
		fc.getApplication().getNavigationHandler().handleNavigation(fc,null,"/pages/logout.jsp");
	}
}

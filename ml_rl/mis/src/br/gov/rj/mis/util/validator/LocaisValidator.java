package br.gov.rj.mis.util.validator;

import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.gov.rj.mis.controller.entityBean.LocalEntityBeanInterface;
import br.gov.rj.mis.model.Locais;
import br.gov.rj.mis.util.UtilImpl;

@ManagedBean
@RequestScoped
public class LocaisValidator {
	@EJB(name = "localEntityBean")
	LocalEntityBeanInterface localEntityBean;

	public void validaNome(FacesContext fc, UIComponent arg1, Object value) {
		String valor = (String) value;
		for (Locais local : localEntityBean.retrieveAll()) {
			if (valor.equals(local.getNome())) {
				ResourceBundle message = UtilImpl.getMessageBundle();
				String mensagem = message.getString("ERRO") + " : "
						+ message.getString("nomeExistente");
				FacesMessage msg = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
				throw new ValidatorException(msg);
			}
		}
	}
}

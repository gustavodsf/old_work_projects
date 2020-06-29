package br.gov.rj.mis.util.validator;

import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.gov.rj.mis.controller.entityBean.IdiomaEntityBeanInterface;
import br.gov.rj.mis.model.Idioma;
import br.gov.rj.mis.util.UtilImpl;

@ManagedBean
@RequestScoped
public class IdiomaValidator {

	@EJB(name = "idiomaEntityBean")
	IdiomaEntityBeanInterface idiomaEntityBean;

	public void validaNome(FacesContext fc, UIComponent arg1, Object value) {
		String valor = (String) value;
		for (Idioma idioma : idiomaEntityBean.retrieveAll()) {
			if (valor.equals(idioma.getNome())) {
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
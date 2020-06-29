package br.gov.rj.mis.util.validator;

import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.gov.rj.mis.controller.entityBean.FuncaoEntityBeanInterface;
import br.gov.rj.mis.model.Funcao;
import br.gov.rj.mis.util.UtilImpl;

@ManagedBean
@RequestScoped
public class FuncaoValidator {

	@EJB(name = "funcaoEntityBean")
	FuncaoEntityBeanInterface funcaoEntityBean;

	public void validaNome(FacesContext fc, UIComponent arg1, Object value) {
		String valor = value.toString();
		for (Funcao funcao : funcaoEntityBean.retrieveAll()) {
			if (valor.equals(funcao.getNome())) {
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
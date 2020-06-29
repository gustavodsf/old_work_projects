package br.gov.rj.mis.util.validator;

import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.gov.rj.mis.controller.entityBean.ColecaoEntityBeanInterface;
import br.gov.rj.mis.model.Colecao;
import br.gov.rj.mis.util.UtilImpl;

@ManagedBean
@RequestScoped
public class ColecaoValidator implements Validator{
	
	@EJB(name="colecaoEntityBean")
	ColecaoEntityBeanInterface colecaoEntityBean;
	
	public void validate(FacesContext fc, UIComponent arg1, Object value){
		String valor = value.toString();
		for (Colecao colecao : colecaoEntityBean.retrieveAll()) {
			if(valor.equals(colecao.getNome())){
				ResourceBundle message = UtilImpl.getMessageBundle();
				String mensagem = message.getString("ERRO") + " : " + message.getString("nomeExistente");
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
				throw new ValidatorException(msg);
			}
		}
		
	}

}

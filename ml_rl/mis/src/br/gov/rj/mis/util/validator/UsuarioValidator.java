package br.gov.rj.mis.util.validator;

import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.gov.rj.mis.controller.entityBean.UsuarioEntityBeanInteface;
import br.gov.rj.mis.util.UtilImpl;

@ManagedBean
@RequestScoped
public class UsuarioValidator {

	@EJB(name = "usuarioEntityBean")
	UsuarioEntityBeanInteface usuarioEntityBean;

	public void validaEmail(FacesContext fc, UIComponent arg1, Object value) {
		
		if (usuarioEntityBean.findUsuarioByEmail(value.toString()) != null) {
			ResourceBundle message = UtilImpl.getMessageBundle();
			String mensagem = message.getString("ERRO") + " : "+ message.getString("emailJaCadastrado");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
			throw new ValidatorException(msg);
		}
	}

	public void validaSenha(FacesContext fc, UIComponent arg1, Object value) {

		UIInput confirmComponent = (UIInput) arg1.getAttributes().get("confirm");
		String confirm = confirmComponent.getSubmittedValue().toString();

		if (!(((String) value).equals(confirm))) {
			ResourceBundle messaBundle = UtilImpl.getMessageBundle();
			String mensagem = messaBundle.getString("senhaDeveConferir");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,mensagem, mensagem);

			throw new ValidatorException(msg);
		}
	}
}

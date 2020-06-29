package br.gov.rj.mis.util;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensagem {
	
	public static void sucesso(String conteudo){
		FacesContext fc = FacesContext.getCurrentInstance();
		ResourceBundle messaBundle = UtilImpl.getMessageBundle();
		String mensagem = messaBundle.getString(TipoMensagem.SUCESSO.toString())+":"+messaBundle.getString(conteudo)+".";
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,mensagem,""));
	}
	
	public static void erro(String conteudo){
		FacesContext fc = FacesContext.getCurrentInstance();
		ResourceBundle messaBundle = UtilImpl.getMessageBundle();
		String mensagem = messaBundle.getString(TipoMensagem.ERRO.toString())+":"+messaBundle.getString(conteudo)+".";
		fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,mensagem,""));
	}
}

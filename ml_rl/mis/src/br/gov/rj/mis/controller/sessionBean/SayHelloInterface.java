package br.gov.rj.mis.controller.sessionBean;

import javax.ejb.Local;

@Local
public interface SayHelloInterface {
	public String sayHello(String name);
}

package br.gov.rj.mis.controller.sessionBean;

import static org.junit.Assert.assertEquals;

import javax.ejb.EJB;

import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Arquillian.class)
public class SayHelloTest {
	
	 @EJB
	 SayHelloInterface say;
	
	 @Deployment
	 public static JavaArchive createDeployment(){
	      JavaArchive jar = ShrinkWrap.create(JavaArchive.class);
	      jar.addClasses(SayHello.class).addClasses(SayHelloInterface.class);
	      jar.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	      System.out.println(jar.toString(true));
	  
	      return jar;
	  }
	 
	 @Test
	 public void sayHallo(){
		  //say = new SayHello();
	      String result = say.sayHello("hehe");
	      assertEquals("Hallo hehe", result);
	   }
	 
	 
	 @Test
	 public void number(){
	      assertEquals("Hallo hehe", "Hallo hehe");
	 }
}

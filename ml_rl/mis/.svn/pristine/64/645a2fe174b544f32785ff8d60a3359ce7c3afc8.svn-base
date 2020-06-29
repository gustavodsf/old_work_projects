package br.gov.rj.mis.util.dataModel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.gov.rj.mis.model.Velocidade;

public class VelocidadeDataModel extends ListDataModel<Velocidade> implements SelectableDataModel<Velocidade>, Serializable {    
	  
		private static final long serialVersionUID = 1L;

		public VelocidadeDataModel() {  
	    }  
	  
	    public VelocidadeDataModel(List<Velocidade> data) {  
	        super(data);  
	    }  
	      
	    @Override  
	    public Velocidade getRowData(String rowKey) {  
	        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
	          
	        List<Velocidade> velocidades = (List<Velocidade>) getWrappedData();  
	          
	        for(Velocidade velocidade : velocidades) {  
	            if(velocidade.getId().equals(rowKey))  {
	            	return velocidade;
	            }
	        }  
	          
	        return null;  
	    }  
	  
	    @Override  
	    public Object getRowKey(Velocidade velocidade) {  
	        return velocidade.getId();  
	    }  
	}  
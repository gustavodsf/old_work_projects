package br.gov.rj.mis.util.dataModel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.gov.rj.mis.model.Idioma;

public class IdiomaDataModel extends ListDataModel<Idioma> implements SelectableDataModel<Idioma>, Serializable {    
	  
		private static final long serialVersionUID = 1L;

		public IdiomaDataModel() {  
	    }  
	  
	    public IdiomaDataModel(List<Idioma> data) {  
	        super(data);  
	    }  
	      
	    @Override  
	    public Idioma getRowData(String rowKey) {  
	        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
	          
	        List<Idioma> idiomas = (List<Idioma>) getWrappedData();  
	          
	        for(Idioma idioma : idiomas) {  
	            if(idioma.getId().equals(rowKey))  {
	            	return idioma;
	            }
	        }  
	          
	        return null;  
	    }  
	  
	    @Override  
	    public Object getRowKey(Idioma idioma) {  
	        return idioma.getId();  
	    }  
	}  
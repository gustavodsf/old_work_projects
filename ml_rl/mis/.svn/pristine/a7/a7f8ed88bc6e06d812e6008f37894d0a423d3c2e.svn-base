package br.gov.rj.mis.util.dataModel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.gov.rj.mis.model.Locais;

public class LocalDataModel extends ListDataModel<Locais> implements SelectableDataModel<Locais>, Serializable {    
	  
		private static final long serialVersionUID = 1L;

		public LocalDataModel() {  
	    }  
	  
	    public LocalDataModel(List<Locais> data) {  
	        super(data);  
	    }  
	      
	    @Override  
	    public Locais getRowData(String rowKey) {  
	        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
	          
	        List<Locais> locais = (List<Locais>) getWrappedData();  
	          
	        for(Locais local : locais) {  
	            if(local.getId().equals(rowKey))  {
	            	return local;
	            }
	        }  
	          
	        return null;  
	    }  
	  
	    @Override  
	    public Object getRowKey(Locais local) {  
	        return local.getId();  
	    }  
	}  
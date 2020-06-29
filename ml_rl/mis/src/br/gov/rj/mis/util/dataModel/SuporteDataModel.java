package br.gov.rj.mis.util.dataModel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.gov.rj.mis.model.Suporte;

public class SuporteDataModel extends ListDataModel<Suporte> implements SelectableDataModel<Suporte>, Serializable {    
	  
		private static final long serialVersionUID = 1L;

		public SuporteDataModel() {  
	    }  
	  
	    public SuporteDataModel(List<Suporte> data) {  
	        super(data);  
	    }  
	      
	    @Override  
	    public Suporte getRowData(String rowKey) {  
	        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
	          
	        List<Suporte> suportes = (List<Suporte>) getWrappedData();  
	          
	        for(Suporte suporte : suportes) {  
	            if(suporte.getId().equals(rowKey)){ 
	                return suporte;  
	            }
	        }  
	          
	        return null;  
	    }  
	  
	    @Override  
	    public Object getRowKey(Suporte suporte) {  
	        return suporte.getId();  
	    }  
	}  

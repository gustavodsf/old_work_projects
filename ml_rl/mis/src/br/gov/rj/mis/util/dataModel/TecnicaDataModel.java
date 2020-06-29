package br.gov.rj.mis.util.dataModel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.gov.rj.mis.model.Tecnica;

public class TecnicaDataModel extends ListDataModel<Tecnica> implements SelectableDataModel<Tecnica>, Serializable {    
	  
		private static final long serialVersionUID = 1L;

		public TecnicaDataModel() {  
	    }  
	  
	    public TecnicaDataModel(List<Tecnica> data) {  
	        super(data);  
	    }  
	      
	    @Override  
	    public Tecnica getRowData(String rowKey) {  
	        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
	          
	        List<Tecnica> tecnicas = (List<Tecnica>) getWrappedData();  
	          
	        for(Tecnica tecnica : tecnicas) {  
	            if(tecnica.getId().equals(rowKey))  {
	            	return tecnica;
	            }
	        }  
	          
	        return null;  
	    }  
	  
	    @Override  
	    public Object getRowKey(Tecnica tecnica) {  
	        return tecnica.getId();  
	    }  
	}  
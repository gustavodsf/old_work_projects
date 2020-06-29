package br.gov.rj.mis.util.dataModel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.gov.rj.mis.model.ProgramaSerieAlbumProjeto;

public class ProgramaSerieAlbumProjetoDataModel extends ListDataModel<ProgramaSerieAlbumProjeto> implements SelectableDataModel<ProgramaSerieAlbumProjeto>, Serializable {    
	  
		private static final long serialVersionUID = 1L;

		public ProgramaSerieAlbumProjetoDataModel() {  
	    }  
	  
	    public ProgramaSerieAlbumProjetoDataModel(List<ProgramaSerieAlbumProjeto> data) {  
	        super(data);  
	    }  
	      
	    @Override  
	    public ProgramaSerieAlbumProjeto getRowData(String rowKey) {  
	        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
	          
	        List<ProgramaSerieAlbumProjeto> psaps = (List<ProgramaSerieAlbumProjeto>) getWrappedData();  
	          
	        for(ProgramaSerieAlbumProjeto psap : psaps) {  
	            if(psap.getId().equals(rowKey))  {
	            	return psap;
	            }
	        }  
	          
	        return null;  
	    }  
	  
	    @Override  
	    public Object getRowKey(ProgramaSerieAlbumProjeto psap) {  
	        return psap.getId();  
	    }  
	}  
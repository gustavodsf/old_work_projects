package br.gov.rj.mis.util.dataModel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.gov.rj.mis.model.Colecao;

public class ColecaoDataModel extends ListDataModel<Colecao> implements SelectableDataModel<Colecao>, Serializable {    
  
	private static final long serialVersionUID = 1L;

	public ColecaoDataModel() {  
    }  
  
    public ColecaoDataModel(List<Colecao> data) {  
        super(data);  
    }  
      
    @Override  
    public Colecao getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
          
        List<Colecao> colecoes = (List<Colecao>) getWrappedData();  
          
        for(Colecao colecao : colecoes) {  
            if(colecao.getSigla().equals(rowKey))  
                return colecao;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(Colecao colecao) {  
        return colecao.getSigla();  
    }  
}  
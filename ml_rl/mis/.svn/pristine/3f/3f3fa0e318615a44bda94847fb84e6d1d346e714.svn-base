package br.gov.rj.mis.util;

public enum EstadoRegistro {
    EXCLUIDO   ("EXCLUIDO"),
    HABILITADO ("HABILITADO");

    private final String name;       

    private EstadoRegistro(String name) {
        this.name = name;
    }

    public boolean equalsName(String otherName){
        return (otherName == null)? false:name.equals(otherName);
    }

    public String toString(){
       return name;
    }
}
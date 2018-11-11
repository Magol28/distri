/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author miguel
 */
public class Insertar {
    
    private String columna;
    private String tipo;
    private Object valor;

    public Insertar(String columna, String tipo, Object valor) {
        this.columna = columna;
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Insertar{" + "columna=" + columna + ", tipo=" + tipo + ", valor=" + valor + '}';
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.Date;

/**
 *
 * @author miguel
 */
public class Reporte2 {
    
    String titulo;
    String isbn;
    Date entrega;

    public Reporte2(String titulo, String isbn, Date entrega) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.entrega = entrega;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getEntrega() {
        return entrega;
    }

    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }
    
}

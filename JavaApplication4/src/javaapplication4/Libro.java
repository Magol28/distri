/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public class Libro {
    @JavaApplication4.Column("isbn")
        private Integer isbn;
    @JavaApplication4.Column("codigo")
        private Integer codigo;
    @JavaApplication4.Column("titulo")
        private String titulo;
    @JavaApplication4.Column("PRESTAMOVALOR")
        private Double pretamovalor;

    public Libro() {
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPretamovalor() {
        return pretamovalor;
    }

    public void setPretamovalor(Double pretamovalor) {
        this.pretamovalor = pretamovalor;
    }

    public Libro(Integer isbn, Integer codigo, String titulo, Double pretamovalor) {
        this.isbn = isbn;
        this.codigo = codigo;
        this.titulo = titulo;
        this.pretamovalor = pretamovalor;
    }
    
    
    
}

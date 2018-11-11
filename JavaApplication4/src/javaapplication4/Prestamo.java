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
public class Prestamo {
    @JavaApplication4.Column("codigoprestamo")
        private Integer codigoprestamo;
    @JavaApplication4.Column("fechaprestamo")
        private Date fechaprestamo;
    @JavaApplication4.Column("descripcion")
        private String descripcion;

    public Integer getCodigoprestamo() {
        return codigoprestamo;
    }

    public void setCodigoprestamo(Integer codigoprestamo) {
        this.codigoprestamo = codigoprestamo;
    }

    public Date getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechaprestamo(Date fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}

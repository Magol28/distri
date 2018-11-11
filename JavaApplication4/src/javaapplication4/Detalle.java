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
public class Detalle {
    @JavaApplication4.Column("isbn")
        private Integer isbn;
    @JavaApplication4.Column("CODIGOPRESTAMO")
        private Integer CODIGOPRESTAMO;
    @JavaApplication4.Column("CANTIDAD")
        private Integer CANTIDAD;
    @JavaApplication4.Column("fechaentrega")
        private Date fechaentrega;

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Integer getCODIGOPRESTAMO() {
        return CODIGOPRESTAMO;
    }

    public void setCODIGOPRESTAMO(Integer CODIGOPRESTAMO) {
        this.CODIGOPRESTAMO = CODIGOPRESTAMO;
    }

    public Integer getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(Integer CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public Date getPretamovalor() {
        return fechaentrega;
    }

    public void setPretamovalor(Date pretamovalor) {
        this.fechaentrega = pretamovalor;
    }
    
    
}

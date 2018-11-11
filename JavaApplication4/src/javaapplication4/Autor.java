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

/**
 *
 * @author miguel
 */@Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Column {

        public String value() default "";
    }
public class Autor {
    @JavaApplication4.Column("codigo")
        private Integer codigo;;
    @JavaApplication4.Column("nombre")
        private String Nombre;
     @JavaApplication4.Column("apellido")
        private String Apellido;;

    @Override
    public String toString() {
        return "Autor{" + "codigo=" + codigo + ", Nombre=" + Nombre + ", Apellido=" + Apellido + '}';
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
  
     

  
}

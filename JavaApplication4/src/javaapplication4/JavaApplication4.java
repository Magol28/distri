/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;


import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javaapplication4.Autor;
import oracle.jdbc.pool.OracleDataSource;
/**
 *
 * @author miguel
 */
public class JavaApplication4 {
   @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Column {

        public String value() default "";
    }
   
    
     
   
 
    public static void main(String[] args) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException {
        
       Autor a= new Autor();
        Libro b= new Libro();
        
        Persistencia per= new Persistencia();
         a.setCodigo(2);
        a.setApellido("angel");
        a.setNombre("angel");
        b.setCodigo(1);
        b.setIsbn(2);
        b.setPretamovalor(12.0);
        b.setTitulo("caliz de fuego");
    /*   // System.out.println( per.Actualizar(per.columnas(a)));
      
       
        Date da = new Date();
       Prestamo pres= new Prestamo();
       Detalle det= new Detalle();
       pres.setCodigoprestamo(2);
       pres.setFechaprestamo(da);
       pres.setDescripcion("bueno");
       
       
       det.setIsbn(2);
       det.setCODIGOPRESTAMO(2);
       det.setCANTIDAD(4);
       det.setPretamovalor(da);
       
        per.putObject(det, "detalle");
       // System.out.println(per.valores(a));
      //  per.getObject(a, "autor").forEach(x -> System.out.println(x.toString()));;*/
        System.out.println(per.GetObject(a,"autor",1).toString());
      ;
    }
    
   
}

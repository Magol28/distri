/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.Date;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author miguel
 */
public class Persistencia {
     public   ArrayList<Object> getObject(Object clase, String tabla) throws SQLException {
         ArrayList<Object> objList = new ArrayList<>();
     OracleDataSource ods = new OracleDataSource();
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            ods.setURL(url);
            ods.setUser("hr");
            ods.setPassword("1234");
           
            try {
            Connection conn = ods.getConnection();
            Statement stmt = conn.createStatement();
             ResultSet rset = stmt.executeQuery("SELECT * FROM "+tabla );
              while (rset.next()) {
                  Object temp= clase.getClass().newInstance();
                   for (Field field : temp.getClass().getDeclaredFields()) {
                        field.setAccessible(true);
                   
                   if (field.isAnnotationPresent(JavaApplication4.Column.class)) {
                            String col_name = field.getAnnotation(JavaApplication4.Column.class).value();
                         
                            if (field.getType().equals(String.class)) {
                                field.set(temp, rset.getString(col_name));
                            } else if (field.getType().equals(Integer.class)) {
                                field.set(temp, rset.getInt(col_name));
                            } else if (field.getType().equals(Date.class)) {
                                field.set(temp, rset.getDate(col_name));
                            } else if (field.getType().equals(Double.class)) {
                                field.set(temp, rset.getDouble(col_name));
                            } else if (field.getType().equals(Float.class)) {
                                field.set(temp, rset.getFloat(col_name));
                            }
                             
                   
                   }
                      
                   }
                   
                  
                   objList.add(temp);
             }
              conn.close();
        } catch (Exception e) {
                System.out.println(e.getCause());
        }
           
         return objList;
    }
     
     public ArrayList<Reporte1> reporte1() throws SQLException{
          ArrayList<Reporte1> lista= new ArrayList<>();
         OracleDataSource ods = new OracleDataSource();
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            ods.setURL(url);
            ods.setUser("hr");
            ods.setPassword("1234");
           
            try {
            Connection conn = ods.getConnection();
            Statement stmt = conn.createStatement();
            String sql= "select titulo,cantidad,autor.nombre nombre from (select  codigo a,  titulo , count(*) cantidad from libro group by codigo,titulo), autor where autor.codigo=a ";
             ResultSet rset = stmt.executeQuery(sql );
                
             while (rset.next()) {
                  
                  lista.add(new Reporte1(rset.getString("titulo"), rset.getString("nombre"), rset.getInt("cantidad")));
                      
                   
             }
              conn.close();
        } catch (Exception e) {
                System.out.println(e.toString());
        }
            return lista;
     }
     
     public  Object GetObject(Object clase, String tabla,int id) throws SQLException, InstantiationException, IllegalAccessException{
        
         ArrayList<Insertar> lista= new ArrayList<>();
         lista=columnas(clase);
         OracleDataSource ods = new OracleDataSource();
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            ods.setURL(url);
            ods.setUser("hr");
            ods.setPassword("1234");
           Object temp= clase.getClass().newInstance();
            try {
            Connection conn = ods.getConnection();
            Statement stmt = conn.createStatement();
            String sql="SELECT * FROM "+tabla +" WHERE "+lista.get(0).getColumna()+"= "+id;
             ResultSet rset = stmt.executeQuery(sql);
             
             while (rset.next()) {
                  
                   for (Field field : temp.getClass().getDeclaredFields()) {
                        field.setAccessible(true);
                   
                   if (field.isAnnotationPresent(JavaApplication4.Column.class)) {
                            String col_name = field.getAnnotation(JavaApplication4.Column.class).value();
                         
                            if (field.getType().equals(String.class)) {
                                field.set(temp, rset.getString(col_name));
                            } else if (field.getType().equals(Integer.class)) {
                                field.set(temp, rset.getInt(col_name));
                            } else if (field.getType().equals(Date.class)) {
                                field.set(temp, rset.getDate(col_name));
                            } else if (field.getType().equals(Double.class)) {
                                field.set(temp, rset.getDouble(col_name));
                            } else if (field.getType().equals(Float.class)) {
                                field.set(temp, rset.getFloat(col_name));
                            }
                             
                   
                   }
                      
                   }
                   
                  
                   
             }
              conn.close();
        } catch (Exception e) {
                System.out.println(e.toString());
        }
         return temp;
     }
     public ArrayList<Reporte2> reporte2() throws SQLException{
          ArrayList<Reporte2> lista= new ArrayList<>();
         OracleDataSource ods = new OracleDataSource();
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            ods.setURL(url);
            ods.setUser("hr");
            ods.setPassword("1234");
           
            try {
            Connection conn = ods.getConnection();
            Statement stmt = conn.createStatement();
            Date da = new Date();
            String sql= "select   titulo,a, b from (select isbn a,fechaentrega b  from detalle where fechaentrega=TO_DATE('11/02/2018','MM/DD/YYYY')), libro  where libro.isbn=a";
             ResultSet rset = stmt.executeQuery(sql );
                
             while (rset.next()) {
                  
                     lista.add(new Reporte2(rset.getString("titulo"), rset.getString("a"), rset.getDate("b")));
                   
             }
              conn.close();
        } catch (Exception e) {
                System.out.println(e.toString());
        }
            return lista;
     }
     
     public void postObject(Object clase, String tabla) throws SQLException, IllegalArgumentException, IllegalAccessException{
         OracleDataSource ods = new OracleDataSource();
         ArrayList<Insertar> in= new ArrayList<>();
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            ods.setURL(url);
            ods.setUser("hr");
            ods.setPassword("1234");
            in=columnas(clase);
        try {     
          // String sql= "UPDATE "+ tabla+" SET "+Actualizar(in)+";";
           String nuevo= Actualizar(in,tabla);
          //  String sql="UPDATE autor SET nombre='angel',apellido='guano' WHERE codigo= 1";

              
            Connection conn = ods.getConnection();
                   
                  Statement preparedStatement = conn.createStatement();
             
            preparedStatement.execute(nuevo);
                   
             
              conn.close();
        } catch (Exception e) {
                System.out.println(e.toString());
        }
     }
     
     public void deleteObject(Object clase, String tabla) throws SQLException, IllegalArgumentException, IllegalAccessException{
         OracleDataSource ods = new OracleDataSource();
         ArrayList<Insertar> in= new ArrayList<>();
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            ods.setURL(url);
            ods.setUser("hr");
            ods.setPassword("1234");
            in=columnas(clase);
        try {     
          // String sql= "UPDATE "+ tabla+" SET "+Actualizar(in)+";";
           String nuevo= Eliminar(in,tabla);
          //  String sql="UPDATE autor SET nombre='angel',apellido='guano' WHERE codigo= 1";

              
            Connection conn = ods.getConnection();
                   
                  Statement preparedStatement = conn.createStatement();
             
            preparedStatement.execute(nuevo);
                   
             
              conn.close();
        } catch (Exception e) {
                System.out.println(e.toString());
        }
     }
      public void putObject(Object clase, String tabla) throws IllegalArgumentException, SQLException, IllegalAccessException{
           OracleDataSource ods = new OracleDataSource();
         ArrayList<Insertar> in= new ArrayList<>();
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            ods.setURL(url);
            ods.setUser("hr");
            ods.setPassword("1234");
            in=columnas(clase);
        try {     
            String sql= "insert into "+ tabla+valores(in)+" values "+valores(in.size());
            int fl=in.size();
         
           
            System.out.println(sql);
                
               
            Connection conn = ods.getConnection();
                   
                  PreparedStatement preparedStatement = conn.prepareStatement(sql);
                     for (int i = 0; i < fl; i++) {
               
                if(in.get(i).getTipo().equals("string")){
                      preparedStatement.setString(i+1, (String) in.get(i).getValor()); 
                }
                if(in.get(i).getTipo().equals("entero")){
                   preparedStatement.setInt(i+1, (int) in.get(i).getValor()); 
                }
                if(in.get(i).getTipo().equals("date")){
                    java.util.Date utilStartDate = (Date)in.get(i).getValor();
                    java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
                  
                      preparedStatement.setDate(i+1, sqlStartDate); 
                }
                if(in.get(i).getTipo().equals("double")){
                    
                    
                     preparedStatement.setDouble(i+1, (double) in.get(i).getValor());  
                }
                if(in.get(i).getTipo().equals("flotante")){
                      preparedStatement.setFloat(i+1, (float) in.get(i).getValor()); 
                }
         }

preparedStatement .executeUpdate();
                   
             
              conn.close();
        } catch (Exception e) {
                System.out.println(e.toString());
        }
      }
     public String valores(int i){
       String valor="(";
       for (int j = 0; j < i; j++) {
           valor+="?,";
       };
       valor=valor.substring(0, valor.length()-1);
  valor+=")";
         
       return valor;
   }
     public String valores(Object temp){
         String valor="";
          for (Field field : temp.getClass().getDeclaredFields()) {
                        field.setAccessible(true);
                   
                   if (field.isAnnotationPresent(JavaApplication4.Column.class)) {
                            String col_name = field.getAnnotation(JavaApplication4.Column.class).value();
                            valor+="-"+col_name;
                          
                             
                   
                   }
                      
                   }
          return valor;
     }
     public String valores(ArrayList<Insertar> in){
         String r="(";
         for (Iterator<Insertar> iterator = in.iterator(); iterator.hasNext();) {
             Insertar next = iterator.next();
            r+=next.getColumna()+",";
         }
        r=r.substring(0, r.length()-1);
  r+=")";
         
       return r;
     }
     public  ArrayList<Insertar> columnas(Object temp) throws IllegalArgumentException, IllegalAccessException
     {
         ArrayList<Insertar> retorno= new ArrayList<>();
      for (Field field : temp.getClass().getDeclaredFields()) {
                        field.setAccessible(true);
                   
                   if (field.isAnnotationPresent(JavaApplication4.Column.class)) {
                            String col_name = field.getAnnotation(JavaApplication4.Column.class).value();
                         
                            if (field.getType().equals(String.class)) {
                               retorno.add(new Insertar(col_name,"string",field.get(temp)));
                            } else if (field.getType().equals(Integer.class)) {
                               retorno.add(new Insertar(col_name,"entero",field.get(temp)));
                            } else if (field.getType().equals(Date.class)) {
                               retorno.add(new Insertar(col_name,"date",field.get(temp)));
                            } else if (field.getType().equals(Double.class)) {
                              retorno.add(new Insertar(col_name,"double",field.get(temp))); 
                            } else if (field.getType().equals(Float.class)) {
                              retorno.add(new Insertar(col_name,"flotante",field.get(temp))); 
                            }
                             
                   
                   }
                      
                   }
         return retorno;
     }
     
     public String Actualizar(ArrayList<Insertar> in,String tabla){
         
         String r="UPDATE "+tabla+" SET ";
         int tam= in.size();
         for (int i = 1; i < tam; i++) {
             if(in.get(i).getTipo().endsWith("string"))
             r+=in.get(i).getColumna()+"='"+in.get(i).getValor()+"',";
             else
             r+=in.get(i).getColumna()+"="+in.get(i).getValor()+",";
         }
          r=r.substring(0, r.length()-1);
          
          r+=" WHERE "+ in.get(0).getColumna()+"= "+in.get(0).getValor();
          System.out.println(r);
         return r;
     }
     
      public String Eliminar(ArrayList<Insertar> in,String tabla){
         
         String r="Delete from "+tabla+" WHERE "+ in.get(0).getColumna()+"= "+in.get(0).getValor();
          
         return r;
     }
}

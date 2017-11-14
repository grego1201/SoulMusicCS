/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft2.conectar;

/**
 *
 * @author Gonzalo
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class Conexion_BBDD {
    private static Connection con;
    
    
    public Conexion_BBDD() throws ClassNotFoundException, SQLException{
        String myDriver = "org.gjt.mm.mysql.Driver";
        Class.forName(myDriver);
        con = DriverManager.getConnection("jdbc:mysql://localhost:4444/musica","root","");
                
    }
    
    public ArrayList<String[]> consulta(String tabla, String [] valores, String condicion) throws ClassNotFoundException, SQLException{
    
        ArrayList<String[]> arr=new ArrayList<>();
        Statement s = con.createStatement(); 
        String v="";
        if(valores.length==0){
            v="*";
        }else{
            for (int i = 0; i < valores.length-1; i++) {
                    v=v+valores[i]+",";
            }
            v=v+valores[valores.length-1];
        }
        String url = "select "+v+" from "+tabla+" where "+condicion;
        ResultSet rs = s.executeQuery (url);


        while (rs.next()) 
        { 
            String [] linea=new String [valores.length];
            for (int i = 0; i < linea.length; i++) {
                linea[i]=rs.getString(valores[i]);
            }
            arr.add(linea);
        }
        con.close();
        
        return arr;
    }
    
    public void insertar(String tabla, String [] valores, String [] v_insertar) throws ClassNotFoundException, SQLException{
   
        String v="";
        String m="";
        
        for (int i = 0; i < valores.length-1; i++) {
            v=v+valores[i]+",";
        }
        v=v+valores[valores.length-1];
        
        
        for (int i = 0; i < v_insertar.length-1; i++) {
            m=m+"'"+v_insertar[i]+"'"+",";
        }
        m=m+"'"+v_insertar[v_insertar.length-1]+"'";
            
        String query = "insert into "+tabla+" ("+v+")"
        + " values ("+m+");";

        Statement st= con.createStatement();
        st.executeUpdate(query);

        con.close();
        
    }
    
    public ArrayList<String[]> update(String tabla, String [] valores,String [] v_insertar, String condicion) throws ClassNotFoundException, SQLException{

        ArrayList<String[]> arr=new ArrayList<>();
        Statement s = con.createStatement(); 
        String v="";
        
        for (int i = 0; i < valores.length-1; i++) {
            v=v+valores[i]+"="+v_insertar[i]+",";
        }
        v=v+valores[valores.length-1]+"="+"'"+v_insertar[valores.length-1]+"'";
        
        String url = "update "+tabla+" set "+v+" where "+condicion;
        
        Statement st= con.createStatement();
        st.executeUpdate(url);
        
        con.close();
        
        return arr;
    }
    
    public ArrayList<String[]> delete(String tabla, String condicion) throws ClassNotFoundException, SQLException{
     
        ArrayList<String[]> arr=new ArrayList<>();
        Statement s = con.createStatement(); 
        
        String url = "delete from "+tabla+" where "+condicion;
        
        Statement st= con.createStatement();
        st.executeUpdate(url);
        
        con.close();
        
        return arr;
    }
    
    
}

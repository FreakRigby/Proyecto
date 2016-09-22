package sistema_supermercado;

import java.sql.*;
import javax.swing.JOptionPane;


public class Clase_sql {
    
    Connection conexion = null;
    Statement sentencia = null;
    
    public void CrearBaseDeDatos() throws ClassNotFoundException, SQLException
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
        }
        catch (ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Base de datos creada!!!");
                
    }
    
    public void CrearTablaProducto() throws ClassNotFoundException, SQLException
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            sentencia = (Statement) conexion.createStatement();
            
            String SQL= "CREATE TABLE PRODUCTOS" +
                    "(ID INT PRIMARY KEY NOT NULL,"+
                    "PRODUCTO TEXT NOT NULL,"+
                    "PRECIO INT NOT NULL)";
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.close();
        }
        catch(ClassNotFoundException | SQLException e)
        {   
            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage(),"error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "tabla productos creada con exito!!! ");
    }
    
    public void CrearTablaCliente()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            sentencia = (Statement) conexion.createStatement();
            
            String SQL= "CREATE TABLE CLIENTES" +
                    "(RUT INT PRIMARY KEY NOT NULL,"+
                    "NOMBRE TEXT NOT NULL,"+
                    "EDAD INT NOT NULL)";
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.close();
        }
        catch(ClassNotFoundException | SQLException e)
        {   
            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage(),"error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "tabla clientes creada con exito!!! ");
    }
    
    public void InsertarProducto(String[]datos ) throws ClassNotFoundException, SQLException //int id, String producto, int precio
    {
        
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            conexion.setAutoCommit(false);
            System.out.println("base de datos abierta");
            sentencia = conexion.createStatement();
        
            String sql= "INSERT INTO PRODUCTOS"+
                    "(ID, PRODUCTO, PRECIO)"+
                    "VALUES('"+datos[0]+"', '"+datos[1]+"', '"+datos[2]+"')";
            sentencia.executeUpdate(sql);
        
            sentencia.close();
            conexion.commit();
            conexion.close();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Datos ingresados con exito!!!");
    }
    
    public void InsertarCliente(String[]datos) //int rut, String nombre, int edad
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            conexion.setAutoCommit(false);
            System.out.println("base de datos abierta");
            sentencia = conexion.createStatement();
        
            String sql= "INSERT INTO CLIENTES"+
                    "(RUT, NOMBRE, EDAD)"+
                    "VALUES('"+datos[0]+"', '"+datos[1]+"', '"+datos[2]+"')";
            sentencia.executeUpdate(sql);
        
            sentencia.close();
            conexion.commit();
            conexion.close();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Datos ingresados con exito!!!");
    }
    
    public void ActualizarProducto(String[]datos) throws ClassNotFoundException, SQLException
            //int id, String producto, int precio
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            conexion.setAutoCommit(false);
            sentencia = conexion.createStatement();
            
            String SQL= "UPDATE PRODUCTOS SET PRODUCTO='"+datos[1]+"',PRECIO='"+datos[2]+"' WHERE ID='"+datos[0]+"'"; 
            
            sentencia.executeUpdate(SQL);
            conexion.commit();
            
            sentencia.close();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
            
        }
        JOptionPane.showMessageDialog(null, "Actualizacion realizada con exito!!");
        
    }
    
    public void ActualizarCliente(String[]datos) //int rut, String nombre, int edad
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            conexion.setAutoCommit(false);
            sentencia = conexion.createStatement();
            
            String SQL= "UPDATE CLIENTES SET NOMBRE='"+datos[1]+"',EDAD='"+datos[2]+"' WHERE RUT='"+datos[0]+"'"; 
            
            sentencia.executeUpdate(SQL);
            conexion.commit();
            
            sentencia.close();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
            
        }
        JOptionPane.showMessageDialog(null, "Actualizacion realizada con exito!!");
    }
    
    public void EliminarProducto(int id)
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            conexion.setAutoCommit(false);
            sentencia = conexion.createStatement();
            
            String SQL= "DELETE FROM PRODUCTOS WHERE ID='"+id+"'";
            
            sentencia.executeUpdate(SQL);
            conexion.commit();
            
            sentencia.close();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
            
        }
        JOptionPane.showMessageDialog(null, "dato eliminado con exito!!");
    }
    
    public void EliminarCliente(int rut)
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:supermercado.sqlite");
            conexion.setAutoCommit(false);
            sentencia = conexion.createStatement();
            
            String SQL= "DELETE FROM CLIENTES WHERE RUT='"+rut+"'";
            
            sentencia.executeUpdate(SQL);
            conexion.commit();
            
            sentencia.close();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
            
        }
        JOptionPane.showMessageDialog(null, "dato eliminado con exito!!");
    }
    
}

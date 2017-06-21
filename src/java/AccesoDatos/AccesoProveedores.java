/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AccesoDatos;

//no es necesario exportar del mismo Package
//import AccesoDatos.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoProveedores extends Conexion{
    /*
    private int calcodigo;
    private String calnombre;
    */
    private ResultSet resultado;

    public AccesoProveedores()
    {
        Conectar();
    }
    
    //actualizar SQL

    //LISTO
    public ResultSet Listado()throws Exception
    {
            try{
             getStmt();
	     resultado= stmt.executeQuery("SELECT * FROM PROVEEDORES");
             return resultado;
              } catch (Exception ex){
           System.err.println("SQLException: " + ex.getMessage());
           return null;
           }
    }
     public void Insertar(String provrut, String provrazon, String provciudad, String provregion, String provdireccion) throws Exception
    {
        //LISTO
           try{
             getStmt();
	     stmt.executeUpdate("INSERT INTO PROVEEDORES values ('" +provrut+ "', '" +provrazon+ "', '" +provciudad+ "', '" +provregion+ "', '" +provdireccion+ "')");
        }catch (Exception ex){
           System.err.println("SQLException: " + ex.getMessage());
        }
    }
     
     //LISTO
   public void Actualizar(String provrut, String provrazon, String provciudad, String provregion, String provdireccion) throws Exception
    {
           try{
             getStmt();
	     stmt.executeUpdate("UPDATE PROVEEDORES set PROVRAZON='"+provrazon+ "',PROVCIUDAD='"+provciudad+ "' ,PROVREGION='"+provregion+ "' ,PROVDIRECCION='"+provdireccion+ "'  WHERE PROVRUT="+provrut);
        }catch (Exception ex){
           System.err.println("SQLException: " + ex.getMessage());
        }
    }
   //LISTO
    public void Eliminar(String provrut)throws Exception
    {
         try{
             getStmt();
	     stmt.executeUpdate("DELETE FROM PROVEEDORES WHERE PROVRUT='" + provrut+"'");
        } catch (Exception ex){
           System.err.println("SQLException: " + ex.getMessage());
        }
    }
    
    //BUSQUEDAS
    public ResultSet BuscarPorRut(String provrut)
    {   try{
             getStmt();
	     resultado= stmt.executeQuery("SELECT * FROM PROVEEDORES WHERE PROVRUT LIKE '" + provrut+"%'");
               return resultado;
             } catch (Exception ex){
           System.err.println("SQLException: " + ex.getMessage());
           return null;
        }
    }

    public ResultSet BuscarPorRazon(String provrazon) throws Exception
    {
        try{

             getStmt();
	     resultado= stmt.executeQuery("SELECT * FROM PROVEEDORES WHERE (PROVRAZON LIKE '" + provrazon + "%')");
             //resultado= stmt.executeQuery("SELECT * FROM CALIDAD WHERE (CALNOMBRE ='" + Nombre + "')");
             return resultado;
              } catch (Exception ex){
           System.err.println("SQLException: " + ex.getMessage());
           return null;
           }
    }
    
    public ResultSet BuscarPorRegion(String provregion) throws Exception
    {
        try{

             getStmt();
	     resultado= stmt.executeQuery("SELECT * FROM PROVEEDORES WHERE (PROVREGION LIKE '" + provregion + "%')");
             //resultado= stmt.executeQuery("SELECT * FROM CALIDAD WHERE (CALNOMBRE ='" + Nombre + "')");
             return resultado;
              } catch (Exception ex){
           System.err.println("SQLException: " + ex.getMessage());
           return null;
           }
    }
    
    public ResultSet BuscarPorRegionYCiudad(String provregion, String provciudad) throws Exception
    {
        try{

             getStmt();
	     resultado= stmt.executeQuery("SELECT * FROM PROVEEDORES WHERE (PROVREGION LIKE '" + provregion + "%') and (PROVREGION LIKE '" + provciudad + "%')");
             //resultado= stmt.executeQuery("SELECT * FROM CALIDAD WHERE (CALNOMBRE ='" + Nombre + "')");
             return resultado;
              } catch (Exception ex){
           System.err.println("SQLException: " + ex.getMessage());
           return null;
           }
    }

}

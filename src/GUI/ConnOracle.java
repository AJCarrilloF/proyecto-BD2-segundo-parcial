/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin Arnold
 */
public class ConnOracle {
    private static String usuarioDB="nodo1";
    private static String passwordDB="nodo";
    private static String serv="orcl";
    private static String dir="localhost";

    public static String getDir() {
        return dir;
    }

    public static void setDir(String dir) {
        ConnOracle.dir = dir;
    }
    
    public static String getUsuarioDB() {
        return usuarioDB;
    }

    public static void setUsuarioDB(String usuarioDB) {
        ConnOracle.usuarioDB = usuarioDB;
    }

    public static String getPasswordDB() {
        return passwordDB;
    }

    public static void setPasswordDB(String passwordDB) {
        ConnOracle.passwordDB = passwordDB;
    }
    
    
    
    public static Connection GetConnection()
    {
        Connection conexion=null;
      
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String servidor = "jdbc:oracle:thin:@"+dir+":1521:"+serv;
            
            System.out.println(servidor+usuarioDB+passwordDB+serv);
            conexion= DriverManager.getConnection(servidor,usuarioDB,passwordDB);
            
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage()+"\n", JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
            while(conexion==null)
            {
                initVal();
                conexion=GetConnection();
            }
                
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        finally
        {
            return conexion;
        }
    }

    public static String getServ() {
        return serv;
    }

    public static void setServ(String serv) {
        ConnOracle.serv = serv;
    }

    private static void initVal() {
        setUsuarioDB(JOptionPane.showInputDialog("Introdusca nombre de usuario"));
        setPasswordDB(JOptionPane.showInputDialog("Introdusca contraseña"));
        setServ(JOptionPane.showInputDialog("Introdusca nombre del servicio"));
        
    }

    static Connection GetConnectionMat(String ip, String serv, String nom, String cont) {
        Connection conexion=null;
      
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String servidor = "jdbc:oracle:thin:@"+ip+":1521:"+serv;
            
            System.out.println(servidor+nom+cont+serv);
            conexion= DriverManager.getConnection(servidor,nom,cont);
            
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage()+"\n", JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        catch(SQLException ex)
        {
            
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            
                
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        finally
        {
            return conexion;
        }
    }
}
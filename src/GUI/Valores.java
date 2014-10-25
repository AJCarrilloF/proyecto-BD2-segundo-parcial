/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angek
 */
public class Valores {
    
    static int sucursal;
    static String nombre;
    static int direccion;

    public static int getSucursal() {
        return sucursal;
    }

    public static void setSucursal(int sucursal) {
        Valores.sucursal = sucursal;
        
        
        try {
            String cons="select sucursal from sucursales"
                    + "where ID_SUCURSAL="+sucursal;
            Connection con;
            con=ConnOracle.GetConnection();
            PreparedStatement st=con.prepareCall(cons);
            ResultSet res= st.executeQuery();
            if(res.next())
            {
                Valores.setNombre(res.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Valores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String getNombre() {
        return nombre;
    }

    private static void setNombre(String nombre) {
        Valores.nombre = nombre;
        try {
            String cons="select ID_Locacion from sucursales"
                    + "where SUCURSAL="+nombre;
            Connection con;
            con=ConnOracle.GetConnection();
            PreparedStatement st=con.prepareCall(cons);
            ResultSet res= st.executeQuery();
            if(res.next())
            {
                Valores.setDireccion(res.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Valores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int getDireccion() {
        return direccion;
    }

    private static void setDireccion(int direccion) {
        Valores.direccion = direccion;
    }
    
    
    
}

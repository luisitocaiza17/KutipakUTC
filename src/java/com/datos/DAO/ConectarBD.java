/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datos.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luisito
 */
public class ConectarBD {
    /*Metodo que permite conectar */
    public Connection realiza_conexion()throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException
    {
        Connection conn = null;
        String userName = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/kutipak";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url, userName, password);
        System.out.println("conneccion exitosa");
        return conn;
    }
	
    public void cerrar_Coneccion(Connection con)throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException
    {
	System.out.println("conneccion cerrada");	
        con.close();
    }
}

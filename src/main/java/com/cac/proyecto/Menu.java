package com.cac.proyecto;

import java.sql.Connection;

public class Menu {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();

        if (conn!=null) {
            System.out.println("anda la conexion");
            
        } else {
            System.out.println("no anda");
        }
        conexion.close();
        
    }
}

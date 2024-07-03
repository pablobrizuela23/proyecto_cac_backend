package com.cac.proyecto;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexion {
  
    private Connection connection;

    public Conexion(){
        try {
            //driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            this.connection=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/datospelis",
                "root",
                "");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }

    //se cierra conexion
    public void close(){
        try {
            if (connection!= null && !connection.isClosed() ) {
                connection.close();
                System.out.println("se cerro la conexion");
            } 
        } catch (   SQLException e) {
            e.printStackTrace();
        }
    }
    
}

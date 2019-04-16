package TPS.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionConfig {

    private String url ="jdbc:mysql://localhost:3306/torneo_frescas?useTimezone=true&serverTimezone=UTC"; // luego del 3306 (puerto) va el nombre de la base de datos
    private String user="root";
    private String password ="";
    private Connection myConnection = null;

    public Connection getConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            myConnection = DriverManager.getConnection( url, user, password);
            System.out.println("CONEXION ESTABLECIDA");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR AL CONECTARSE");
        }

        return myConnection;
    }



}
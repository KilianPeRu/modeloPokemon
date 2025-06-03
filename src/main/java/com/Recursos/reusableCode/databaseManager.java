package com.Recursos.reusableCode;

import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class databaseManager {
    //Declaración de variables
    private static String url;
    private static String user;
    private static String psswd;
    private static java.sql.Connection con;
    String username;
    int uuid;

    public databaseManager(int uuid) throws SQLException, ClassNotFoundException {
        this.uuid = uuid;
        connect();
        this.username = obtenerUsername();
    }

    //Función que se encarga de conectar a la base de datos
    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        url = "jdbc:mysql://localhost:3306/Javamon";
        user = "root";
        psswd = "root";
        con = DriverManager.getConnection(url, user, psswd);
    }

    public String obtenerUsername() throws SQLException {
            String query = "SELECT * FROM users WHERE idUsuario like " + "'" + uuid + "'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println("Recibiendo Nombre...");
            while (rs.next()) {
                String nombreUser = rs.getString("name");
                System.out.println("Nombre: " + nombreUser);
                return nombreUser;
            }
            return null;
    }
    public String getUsername(){
        return username;
    }

}

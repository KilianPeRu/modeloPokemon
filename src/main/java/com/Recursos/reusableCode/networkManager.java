package com.Recursos.reusableCode;

import java.sql.DriverManager;
import java.sql.SQLException;

public class networkManager {
    //Declaración de variables
    private static String url;
    private static String user;
    private static String psswd;
    private static boolean conectado;
    private static java.sql.Connection con;

    //Constructor de la clase
    public networkManager() {

    }

    //Función que se encarga de conectar a la base de datos
    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        url = "jdbc:mysql://localhost:3306/Javamon";
        user = "root";
        psswd = "root";
        con = DriverManager.getConnection(url, user, psswd);
        conectado = true;
    }
    //Función que se encarga de desconectar de la base de datos
    public static void disconnect() {

    }
    //Funcion que se encarga de actualizar la información a la base de datos
    public static void updateIp() {

    }
    //Función que se encarga de obtener la información de la base de datos
    public static void getPort() {

    }
    //Función que se encarga de enviar la información a la base de datos
    public static void sendPort() {

    }
}

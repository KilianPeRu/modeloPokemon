package com.Recursos.reusableCode;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class networkManager {
    //Declaración de variables
    private static String url;
    private static String user;
    private static String psswd;
    private static boolean conectado;
    private static java.sql.Connection con;
    private Socket socket;
    String ip = "localhost";
    int port = 3306;
    private String trainerName;

    //Constructor de la clase
    public networkManager(String trainerName) throws UnknownHostException, SQLException, ClassNotFoundException {
        this.trainerName = trainerName;
        connect();
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
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("No se pudo cerrar la conexión con la base de datos");
        }
        conectado = false;
    }
    //Funcion que se encarga de actualizar la información a la base de datos
    public void updateIp() throws SQLException, ClassNotFoundException {
        if(!ip.equals(getIpBBDD(trainerName))){
            sendPort(trainerName);
            System.out.println("IP actualizada!");
        }else{
            System.out.println("IP es la misma que la actual! No se actualizó nada.");
            disconnect();
        }
    }
    //Función que se encarga de obtener la información de la base de datos
    public void getPort() {
        try {
            socket = new Socket(ip, 3306);
            System.out.println("Conectado a " + ip + " en el puerto " + port);
        } catch (Exception e) {
            System.out.println("No se pudo conectar a " + ip + " en el puerto " + port);
        }
        try {
            socket.close();
        } catch (Exception e) {}

    }
    //Función que se encarga de obtener la dirección IP de la bbdd
    public static String getIpBBDD(String trainerName) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM users WHERE name like " + "'" + trainerName + "'";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        System.out.println("Recibiendo IP...");
        while (rs.next()) {
            String ip = rs.getString("ip");
            System.out.println("IP: " + ip);
            return ip;
        }
        return null;
    }
    //Función que se encarga de enviar la información a la base de datos
    public void sendPort(String trainerName) throws SQLException, ClassNotFoundException {
        String query = "UPDATE users SET ip = " + "'" + ip + "'" + " WHERE name like " + "'" + trainerName + "'";
        PreparedStatement ps = con.prepareStatement(query);
        ps.executeUpdate();
        System.out.println("Enviando IP...");
    }
}

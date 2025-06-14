package com.BattleCPU.resources;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MoneyManager {
    int dinero;
    String uuid;
    private static String url;
    private static String user;
    private static String psswd;
    private static java.sql.Connection con;

    public MoneyManager(int dinero, String uuid) throws ClassNotFoundException, SQLException {
        this.uuid = uuid;
        this.dinero = dinero;
    }

    public void updateMoney() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        url = "jdbc:mysql://localhost:3306/Javamon";
        user = "root";
        psswd = "root";
        con = DriverManager.getConnection(url, user, psswd);
        String query = "UPDATE users SET money = money + " + dinero +" WHERE idUsuario = " + uuid;
        PreparedStatement ps = con.prepareStatement(query);
        ps.executeUpdate();
    }

    public int getMoney() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        url = "jdbc:mysql://localhost:3306/Javamon";
        user = "root";
        psswd = "root";
        con = DriverManager.getConnection(url, user, psswd);
        String query = "SELECT money FROM users WHERE idUsuario = " + uuid;
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            dinero = rs.getInt("money");
            return dinero;
        }
        return 0;
    }


}

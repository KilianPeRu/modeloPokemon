package com.mycompany.resources;

import java.sql.*;
import java.util.ArrayList;

public class CargarEquipoRival {
    String url;
    String user;
    String psswd;
    String rival;
    Connection con;
    boolean conectado;
    ArrayList<Pokemon> listaPokemon = new ArrayList<>();

    public void connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        url = "jdbc:mysql://localhost:3306/Javamon";
        user = "root";
        psswd = "root";
        con = DriverManager.getConnection(url, user, psswd);
        conectado = true;
    }

    public ArrayList cargarEquipo(String usuarioEquipo) throws SQLException, ClassNotFoundException {
        connect();
        String query = "SELECT * FROM Pokemon WHERE trainerName like " + "'" + usuarioEquipo + "'";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        System.out.println("Cargando equipo de " + usuarioEquipo + ":");
        while (rs.next()) {
            int idPokemon = rs.getInt("idPokemon");
            String nombreTrainer = rs.getString("trainerName");
            String nombre = rs.getString("name");
            String especie = rs.getString("specie");
            String tipo1 = rs.getString("type1");
            String tipo2 = rs.getString("type2");
            if (tipo2 == null) {
                tipo2 = "";
            }
            int hp = rs.getInt("hp");
            int atk = rs.getInt("atk");
            int def = rs.getInt("def");
            int eat = rs.getInt("eAtk");
            int edf = rs.getInt("eDef");
            int vel = rs.getInt("spd");
            int m1 = rs.getInt("move1");
            int m2 = rs.getInt("move2");
            int m3 = rs.getInt("move3");
            int m4 = rs.getInt("move4");
            Pokemon p = new Pokemon(nombreTrainer, nombre, especie, tipo1, tipo2, null, null, hp, atk, def, eat, edf, vel, m1, m2, m3, m4);
            System.out.println(p.getNombre()+"\n-----------------------");
            p.setMovimientos(cargarMovimiento(p));
            for (Movimiento m : p.getMovimientos()) {
                System.out.println(m.getNombre());
            }
            listaPokemon.add(p);
        }
        return listaPokemon;
    }

    public Movimiento[] cargarMovimiento(Pokemon p) throws SQLException, ClassNotFoundException {
        connect();
        ArrayList<Movimiento> movimientos = new ArrayList<>();
        String query = "SELECT * FROM moves WHERE idMove IN (" + p.getM1() + "," + p.getM2() + "," + p.getM3() + "," + p.getM4() + ")";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    int potencia = rs.getInt("potencia");
                    int accuracy = rs.getInt("accuracy");
                    String clase = rs.getString("clase");
                    int priority = rs.getInt("priority");
                    String type = rs.getString("type");
                    Movimiento m = new Movimiento(name, priority, potencia, accuracy, type, 20, clase);
                    movimientos.add(m);
                }
            }
        }
        Movimiento[] mov = new Movimiento[movimientos.size()];
        int indice = 0;
        for (Movimiento m : movimientos) {
            mov[indice] = m;
            indice++;
        }
        return mov;
    }
}

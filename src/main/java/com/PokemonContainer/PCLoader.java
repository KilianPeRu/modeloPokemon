package com.PokemonContainer;

import com.BattleCPU.resources.Movimiento;
import com.BattleCPU.resources.Pokemon;

import java.sql.*;
import java.util.ArrayList;

public class PCLoader {

    private ArrayList<Pokemon> pokemonsPC;
    private String userName;
    private String url;
    private String user;
    private String psswd;
    private String rival;
    private Connection con;
    private boolean conectado;
    public PCLoader() {}

    public void connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        url = "jdbc:mysql://localhost:3306/Javamon";
        user = "root";
        psswd = "root";
        con = DriverManager.getConnection(url, user, psswd);
        conectado = true;
    }
    public ArrayList<Pokemon> loadPC(String usuarioEquipo) throws SQLException, ClassNotFoundException {
        connect();
        ArrayList<Pokemon> CPUPokemons = new ArrayList<>();
        String query = "SELECT * FROM Pokemon WHERE trainerName like " + "'" + usuarioEquipo + "'" + " AND team = false";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        System.out.println("Cargando caja de " + usuarioEquipo + ":");
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
            Pokemon p = new Pokemon(idPokemon, nombreTrainer, nombre, especie, tipo1, tipo2, null, null, hp, atk, def, eat, edf, vel, m1, m2, m3, m4);
            System.out.println(p.getNombre()+"\n-----------------------");
            p.setMovimientos(cargarMovimientos(p));
            for (Movimiento m : p.getMovimientos()) {
                System.out.println(m.getNombre());
            }
            CPUPokemons.add(p);
        }
        return CPUPokemons;
    }
    public Movimiento[] cargarMovimientos(Pokemon p) throws SQLException, ClassNotFoundException {
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

    public void changeManager(Pokemon pEquipo, Pokemon pCaja) throws SQLException, ClassNotFoundException {
        deleteManager(pEquipo);
        addManager(pCaja);
    }
    public void deleteManager(Pokemon pEquipo) throws SQLException, ClassNotFoundException {
        connect();
        String query = "UPDATE FROM SET team = false Pokemon WHERE idPokemon = " + pEquipo.getIdPokemon();
        PreparedStatement ps = con.prepareStatement(query);
        ps.executeUpdate();
    }
    public void addManager(Pokemon pCaja) throws SQLException, ClassNotFoundException {
        connect();
        String query = "UPDATE FROM SET team = true Pokemon WHERE idPokemon = " + pCaja.getIdPokemon();
        PreparedStatement ps = con.prepareStatement(query);
        ps.executeUpdate();
    }
}

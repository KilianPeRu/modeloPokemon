package com.BattleCPU.gui;

import com.BattleCPU.resources.CargarEquipoRival;
import com.BattleCPU.resources.Movimiento;
import com.BattleCPU.resources.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class interfazCodigo {
    static CargarEquipoRival c = new CargarEquipoRival();
    static ArrayList<Pokemon> equipo;

    public interfazCodigo() throws SQLException, ClassNotFoundException {
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        equipo = c.cargarEquipo("betabot3");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Pokemons");
        frame.add(createSwitchBattlePanel());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static JPanel createSwitchBattlePanel(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(createTop(equipo.get(0)), BorderLayout.NORTH);
        panel.add(createWest(equipo), BorderLayout.WEST);
        panel.add(createCenter(equipo.get(0)), BorderLayout.CENTER);
        panel.add(createBottom(), BorderLayout.SOUTH);
        return panel;
    }

    public static JPanel createTop(Pokemon pokemonSelected){
        JPanel panel = new JPanel(new BorderLayout());
        JLabel nombre = new JLabel(pokemonSelected.getNombre());
        JLabel nivelPokemon = new JLabel("LV. " + String.valueOf(pokemonSelected.getNivel()));
        panel.add(nombre, BorderLayout.WEST);
        panel.add(nivelPokemon, BorderLayout.EAST);
        panel.setVisible(true);
        return panel;
    }

    public static JPanel createCenter(Pokemon pokemonSelected){
        JPanel panel = new JPanel(new GridLayout(0,3));

        //CREACION DE LA PARTE IZQUIERDA
        panel.add(createCenterLeft(pokemonSelected));

        // CREACION DE LA PARTE CENTRAL
        panel.add(createDatos(pokemonSelected));

        //CREACION PARTE DERECHA
        JPanel estadisticas = createStats(pokemonSelected);
        panel.add(estadisticas);

        return panel;
    }

    public static JPanel createWest(ArrayList<Pokemon> equipo){
        JPanel panel = new JPanel(new GridLayout(equipo.size(), 1));
        for (int i = 0; i < equipo.size(); i++) {
            JButton button = new JButton();
            button.setOpaque(true);
            String imagenPokemon = equipo.get(i).getEspecie().toLowerCase()+".png";
            String path = "src/main/java/com/Recursos/pokemonImages/"+imagenPokemon;
            ImageIcon icon = new ImageIcon(path);
            Icon image = new ImageIcon(icon.getImage().getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH));
            button.setIcon(image);
        }
        return panel;
    }

    public static JPanel createBottom(){
        JPanel panel = new JPanel(new FlowLayout());

        JButton btnSwitch = new JButton("Switch");
        btnSwitch.setBackground(new Color(78, 253, 82));
        panel.add(btnSwitch);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBackground(new Color(253, 78, 78));
        panel.add(btnCancel);

        return panel;
    }

    public static JPanel createCenterLeft(Pokemon pokemonSelected){
        JPanel panel = new JPanel(new GridLayout(2,1));

        JPanel aux = new JPanel(new FlowLayout());
        JButton objeto = new JButton();
        objeto.setOpaque(true);
        if(pokemonSelected.getObjeto() != null){
            String imagenObjeto = pokemonSelected.getObjeto().toLowerCase().replace(" ", "")+".png";
            String path2 = "src/main/java/com/Recursos/objetos/"+imagenObjeto;
            ImageIcon iconObjeto = new ImageIcon(path2);
            objeto.setIcon(iconObjeto);
            aux.add(objeto, FlowLayout.RIGHT);
        }
        panel.add(aux);

        JLabel pokemonImage = new JLabel();
        String imagenPokemon = pokemonSelected.getEspecie().toLowerCase()+".png";
        String path = "src/main/java/com/Recursos/pokemonImages/"+imagenPokemon;
        ImageIcon iconPokemon = new ImageIcon(path);
        Icon image = new ImageIcon(iconPokemon.getImage().getScaledInstance(panel.getWidth()-20, panel.getHeight()-aux.getHeight()-20, java.awt.Image.SCALE_SMOOTH));
        pokemonImage.setIcon(image);
        panel.add(pokemonImage);

        return panel;
    }

    public static JPanel createDatos(Pokemon pokemonSelected){
        JPanel panel = new JPanel(new GridLayout(0,1));
        JPanel tipos = new JPanel(new FlowLayout());
        JLabel nombre = new JLabel(pokemonSelected.getNombre());
        JLabel idTrainer = new JLabel(pokemonSelected.getIdTrainer());

        JLabel tipo1 = new JLabel(pokemonSelected.getTipo1());
        JLabel tipo2 = new JLabel(pokemonSelected.getTipo2());
        tipos.add(tipo1);
        tipos.add(tipo2);

        JPanel movimientos = createMoves(pokemonSelected.getMovimientos());

        panel.add(nombre);
        panel.add(idTrainer);
        panel.add(movimientos);
        return panel;
    }

    public static JPanel createMoves(Movimiento[] moves){
        JPanel panel = new JPanel(new GridLayout(4, 1));
        for (int i = 0; i < moves.length; i++) {
            JButton button = new JButton(moves[i].getNombre());
            button.setOpaque(true);
            panel.add(button);
        }
        return panel;
    }
    public static JPanel createStats(Pokemon pokemon){
        JPanel panel = new JPanel(new FlowLayout());

        JLabel hp = new JLabel(String.valueOf(pokemon.getHp()));
        JLabel ataque = new JLabel(String.valueOf(pokemon.getAtq()));
        JLabel defensa = new JLabel(String.valueOf(pokemon.getDef()));
        JLabel ataqueEspecial = new JLabel(String.valueOf(pokemon.getEat()));
        JLabel defensaEspecial = new JLabel(String.valueOf(pokemon.getEdf()));
        JLabel velocidad = new JLabel(String.valueOf(pokemon.getVel()));

        panel.add(hp);
        panel.add(ataque);
        panel.add(defensa);
        panel.add(ataqueEspecial);
        panel.add(defensaEspecial);
        panel.add(velocidad);

        return panel;
    }
}
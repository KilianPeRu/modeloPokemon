package com.mycompany.resources;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class mainPeleasAlpha extends JFrame {
    Pokemon p1;
    Pokemon p2;
    Pokemon p3;
    Pokemon p4;

    private ArrayList<Pokemon> teamUser;
    private ArrayList<Pokemon> teamCPU;
    int[] hpEquipo;
    Pokemon pActual;
    Pokemon pCPU;
    JProgressBar barrap1;
    JProgressBar barrap2;

    public static void main(String[] args) {
        mainPeleasAlpha app = new mainPeleasAlpha();
        app.gameStart();

        JFrame frame = new JFrame("Alpha Battle");
        frame.add(app.initComponents());
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void gameStart() {
        p1 = new Pokemon("111111A", "Charmander", "Charmander", "Fuego", "null", "Blaze", null,
                39, 52, 43, 60, 50, 65,1,1,1,1);
        p2 = new Pokemon("111111A", "Bulbasaur", "Bulbasaur", "Planta", "Veneno", "Overgrwoth", null,
                45, 49, 49, 65, 65, 45,1,1,1,1);
        p3 = new Pokemon("000001A", "Test1", "Azumarill", "Agua", "Hada",
                "Fuerza Bruta", "Cinta Eleccion", 100, 50, 80, 60, 80, 50,1,1,1,1);
        p4 = new Pokemon("0000001A", "Test3", "Primeape", "Lucha", "null",
                "Irascible", "null", 100, 105, 60, 60, 70, 95,1,1,1,1);
        //Setteo de movimientos de Charmander
        Movimiento m1 = new Movimiento("Ascuas", 0, 40, 100, "Fuego", 40, "Especial");
        Movimiento m2 = new Movimiento("Placaje", 0, 40, 100, "Normal", 40, "Fisico");
        Movimiento m3 = new Movimiento("Lanzallamas", 0, 80, 100, "Fuego", 40, "");
        Movimiento m4 = new Movimiento("Ataque Rapido", 1, 40, 100, "Normal", 40, "Fisico");
        Movimiento[] movep1 = new Movimiento[]{m1, m2, m3, m4};
        p1.setMovimientos(movep1);
        //Setteo de movimientos de Bulbasaur
        Movimiento m5 = new Movimiento("Absorber", 0, 40, 100, "Planta", 40, "Especial");
        Movimiento m6 = new Movimiento("Follaje", 0, 40, 100, "Planta", 40, "Fisico");
        Movimiento m7 = new Movimiento("Placaje", 0, 40, 100, "Normal", 40, "Fisico");
        Movimiento m8 = new Movimiento("Ácido", 0, 40, 100, "Veneno", 40, "Especial");
        Movimiento[] movep2 = new Movimiento[]{m5, m6, m7, m8};
        p2.setMovimientos(movep2);

        Movimiento m9 = new Movimiento("Burbuja", 0, 40, 100, "Agua", 40, "Especial");
        Movimiento m10 = new Movimiento("Placaje", 0, 40, 100, "Normal", 40, "Fisico");
        Movimiento m11 = new Movimiento("Viento Feerico", 0, 40, 100, "Hada", 40, "Especial");
        Movimiento m12 = new Movimiento("Picotazo", 0, 40, 100, "Volador", 40, "Fisico");
        Movimiento[] movep3 = new Movimiento[]{m9, m10, m11, m12};
        p3.setMovimientos(movep3);

        Movimiento[] movep4 = new Movimiento[]{m4, m6, m1, m12};
        p4.setMovimientos(movep4);

        teamUser = new ArrayList<>() {{
            add(p3);
            add(p2);
        }};
        teamCPU = new ArrayList<>() {{
            add(p1);
            add(p4);
        }};
        hpEquipo = baseHPTeam(teamUser);
        pActual = teamUser.get(0);
        pCPU = teamCPU.get(0);
        barrap1 = createBarraHP(pActual);
        barrap2 = createBarraHP(pCPU);
    }

    public JPanel initComponents() {
        JPanel panel = new JPanel(new BorderLayout());

        // Panel central que muestra los Pokémon
        JPanel panelPokemon = new JPanel(new BorderLayout());

        JPanel panelPokemonUser = createPokemon(pActual, barrap1);
        JPanel panelPokemonCPU = createPokemon(pCPU, barrap2);

        panelPokemon.add(panelPokemonUser, BorderLayout.WEST);
        panelPokemon.add(panelPokemonCPU, BorderLayout.EAST);

        // Panel inferior para los botones de movimientos
        JPanel panelBotones = createAttackButton(pActual.getMovimientos(), panelPokemon);

        // Agrega el equipo del usuario y otros paneles
        panel.add(createTeam(teamUser, panelPokemon, panelBotones), BorderLayout.WEST);
        panel.add(panelPokemon, BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        return panel;
    }


    public JPanel createAttackButton(Movimiento[] moves, JPanel panelPokemon) {
        Batalla battle = new Batalla(pActual, pCPU);
        JPanel panel = new JPanel();
        for (int i = 0; i < moves.length; i++) {
            int indice = i;
            JButton ataque = new JButton(moves[i].getNombre());
            ataque.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Movimiento movimientoCPU = battle.calcularMejorOpcion(pCPU.getMovimientos());
                    int orden = battle.ordenAtaques(moves[indice], movimientoCPU);
                    if (orden == 1) {
                        reducirHP(barrap2, pCPU, battle.calculoDano(moves[indice], pActual, pCPU));
                        if (!comprobarVictoriaJugador(barrap2, teamCPU, panelPokemon, barrap2)) {
                            reducirHP(barrap1, pActual, battle.calculoDano(movimientoCPU, pCPU, pActual));
                            comprobarVictoriaCPU(barrap1, teamUser, panelPokemon, panel);
                        }
                    } else {
                        reducirHP(barrap1, pActual, battle.calculoDano(movimientoCPU, pCPU, pActual));
                        if (!comprobarVictoriaCPU(barrap1, teamUser, panelPokemon, panel)) {
                            reducirHP(barrap2, pCPU, battle.calculoDano(moves[indice], pActual, pCPU));
                            comprobarVictoriaJugador(barrap2, teamCPU, panelPokemon, barrap2);
                        }
                    }
                }
            });
            panel.add(ataque);
        }
        return panel;
    }

    public JPanel createPokemon(Pokemon p, JProgressBar barraHP) {
        JPanel panelPokemon = new JPanel(new BorderLayout());

        JLabel label = new JLabel(p.getNombre());

        JLabel imagen = new JLabel();
        ImageIcon icon = new ImageIcon("src/main/java/com/mycompany/gui/imagenes/" + p.getEspecie().toLowerCase() + ".png");
        imagen.setIcon(icon);

        panelPokemon.add(label, BorderLayout.NORTH);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        panelPokemon.add(imagen, BorderLayout.CENTER);
        imagen.setHorizontalAlignment(SwingConstants.CENTER);

        panelPokemon.add(barraHP, BorderLayout.SOUTH);

        return panelPokemon;
    }

    public JProgressBar createBarraHP(Pokemon p) {
        JProgressBar barraHP = new JProgressBar(0, p.getHp());
        barraHP.setValue(p.getHp());
        barraHP.setMaximum(p.getHp());
        barraHP.setStringPainted(true);
        barraHP.setForeground(p.getColorType());
        barraHP.setBorder(new LineBorder(Color.BLACK, 2));
        return barraHP;
    }

    public void reducirHP(JProgressBar barra, Pokemon p, int cantidad) {
        p.setHp(p.getHp() - cantidad);
        barra.setValue(p.getHp());
    }

    public int calculoHP(Pokemon p) {
        return (int) (((double) (2 * p.getHp()) / 100) * 50 + 50 + 10);
    }

    public boolean comprobarVictoriaJugador(JProgressBar barra, ArrayList<Pokemon> equipoCPU, JPanel panelPokemon,
                                            JProgressBar barrap2) {
        if (barra.getValue() <= 0) {
            boolean reemplazado = false;
            for (int i = 0; i < equipoCPU.size(); i++) {
                if (equipoCPU.get(i).getHp() > 0) {
                    pCPU = equipoCPU.get(i); // Cambia al nuevo Pokémon del CPU
                    barrap2.setMaximum(equipoCPU.get(i).getHp());
                    barrap2.setValue(equipoCPU.get(i).getHp());
                    barrap2.setForeground(pCPU.getColorType());
                    // Actualiza el panel del Pokémon actual
                    panelPokemon.removeAll();
                    panelPokemon.add(createPokemon(pActual, barrap1), BorderLayout.WEST);
                    panelPokemon.add(createPokemon(pCPU, barrap2), BorderLayout.EAST);
                    panelPokemon.revalidate();
                    panelPokemon.repaint();
                    reemplazado = true;
                    break;
                }
            }
            if (!reemplazado) {
                int option = JOptionPane.showOptionDialog(null, "¡Has ganado la batalla! Todos los Pokémon del CPU han sido debilitados.",
                        "FIN", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                        new Object[]{"OK"}, "OK"
                );

                if (option == JOptionPane.OK_OPTION || option == JOptionPane.CLOSED_OPTION) {
                    System.exit(1);
                }
            }
            return true;
        }
        return false;
    }


    public boolean comprobarVictoriaCPU(JProgressBar barra, ArrayList<Pokemon> equipoUser, JPanel panelPokemon, JPanel panelBotones) {
        if (barra.getValue() <= 0) {
            // Filtra los Pokémon vivos
            ArrayList<Pokemon> pokemonVivos = new ArrayList<>();
            for (Pokemon pokemon : equipoUser) {
                if (pokemon.getHp() > 0) {
                    pokemonVivos.add(pokemon);
                }
            }

            if (pokemonVivos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "¡El CPU ha ganado la batalla! Todos tus Pokémon han sido debilitados.",
                        "FIN", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            String[] opcionesPokemon = pokemonVivos.stream().map(Pokemon::getNombre).toArray(String[]::new);
            int seleccion = JOptionPane.showOptionDialog(null, "Elige tu siguiente Pokémon",
                    "Cambio de Pokémon", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, opcionesPokemon, opcionesPokemon[0]);

            while (seleccion < 0) {
                seleccion = JOptionPane.showOptionDialog(null, "Tienes que elegir un Pokemon",
                        "Cambio de Pokémon", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, opcionesPokemon, opcionesPokemon[0]);
            }

            Pokemon seleccionado = pokemonVivos.get(seleccion);
            pActual = seleccionado;
            repinta(panelPokemon, panelBotones);

            int indiceSeleccionado = equipoUser.indexOf(seleccionado);
            barra.setMaximum(hpEquipo[indiceSeleccionado]);
            barra.setValue(seleccionado.getHp());
            barra.setForeground(pActual.getColorType());
            return true;
        }
        return false;
    }


    private JPanel createTeam(ArrayList<Pokemon> listaPokemon, JPanel panelPokemon, JPanel panelBotones) {
        JPanel panel = new JPanel(new GridLayout(listaPokemon.size(), 1));
        for (int i = 0; i < listaPokemon.size(); i++) {
            JButton button = new JButton(listaPokemon.get(i).getNombre());
            int indice = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (listaPokemon.get(indice) == pActual) {
                        JOptionPane.showMessageDialog(null, listaPokemon.get(indice).getNombre() + " esta en combate");
                    } else {
                        if (listaPokemon.get(indice).getHp() <= 0) {
                            JOptionPane.showMessageDialog(null, listaPokemon.get(indice).getNombre() + " esta debilitado");
                        } else {
                            Batalla bAux = new Batalla(pActual, pCPU);
                            Movimiento m = bAux.calcularMejorOpcion(pCPU.getMovimientos());
                            // Cambia el Pokémon actual
                            pActual = listaPokemon.get(indice);
                            barrap1.setMaximum(hpEquipo[indice]);
                            barrap1.setValue(listaPokemon.get(indice).getHp());
                            barrap1.setForeground(pActual.getColorType());

                            repinta(panelPokemon, panelBotones);

                            reducirHP(barrap1, pActual, bAux.calculoDano(m, pCPU, pActual));
                            comprobarVictoriaCPU(barrap1, teamUser, panelPokemon, panelBotones);
                        }
                    }
                }
            });
            panel.add(button);
        }
        return panel;
    }

    public int[] baseHPTeam(ArrayList<Pokemon> listaPokemon) {
        int[] baseHP = new int[listaPokemon.size()];
        for (int i = 0; i < listaPokemon.size(); i++) {
            baseHP[i] = calculoHP(listaPokemon.get(i));
            listaPokemon.get(i).setHp(baseHP[i]);
        }
        return baseHP;
    }

    public void repinta(JPanel panelPokemon, JPanel panelBotones) {
        // Actualiza el panel
        panelPokemon.removeAll();
        panelPokemon.add(createPokemon(pActual, barrap1), BorderLayout.WEST);
        panelPokemon.add(createPokemon(pCPU, barrap2), BorderLayout.EAST);
        panelPokemon.revalidate();
        panelPokemon.repaint();
        // Actualiza los botones de ataque
        panelBotones.removeAll();
        JPanel nuevosBotones = createAttackButton(pActual.getMovimientos(), panelPokemon);
        panelBotones.add(nuevosBotones);
        panelBotones.revalidate();
        panelBotones.repaint();
    }
}


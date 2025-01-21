package com.BattleCPU.resources;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;


public class mainPeleasAlpha {
    // Iniciando variables necesarias para la aplicacion
    CargarEquipoRival crCPU = new CargarEquipoRival(); // Recurso de carga para equipo de la CPU
    CargarEquipoRival crUser = new CargarEquipoRival(); // Recurso de carga de nuestro Equipo
    private ArrayList<Pokemon> teamUser; // Arraylist de los Pokemon que almacenaremos del equipo Usuario
    private ArrayList<Pokemon> teamCPU; // Arraylist de los Pokemon que almacenaremos del equipo CPU
    int[] hpEquipo; // Guardaremos el máximo HP de los pokémons y setteará bien los HP de cada uno
    Pokemon pActual; // Pokemon del Usuario en uso
    Pokemon pCPU; // Pokemon que usa la CPU en este momento
    JProgressBar barrap1; // Barra de vida Usuario
    JProgressBar barrap2; // Barra de vida de la CPU

    public mainPeleasAlpha() throws SQLException, ClassNotFoundException {
        // Empezamos la aplicacion y hacemos el JFrame que lo almacena
        gameStart();
        JFrame frame = new JFrame("Alpha Battle");
        frame.add(initComponents());
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void gameStart() throws SQLException, ClassNotFoundException {
        //Inicializan las variables
        teamUser = crUser.cargarEquipo("betabot3");// Carga el equipo del Usuario
        teamCPU = crCPU.cargarEquipo("betabot1");//Carga el equipo de la CPU
        hpEquipo = baseHPTeam(teamUser); // Settea la vida de los pokemon y las almacena para su posterior uso
        pActual = teamUser.get(0); // Empieza la batalla siendo el pokemon en uso el primero que hay en el equipo
        pCPU = teamCPU.get(0); // Empieza la batalla con el primer pokemon de la CPU
        barrap1 = createBarraHP(pActual); //Crea la barra de HP del Pokemon Usuario y pone el valor de ese Pokemon
        barrap2 = createBarraHP(pCPU); //Crea la barra de HP del Pokemon CPU y establece el valor de ese Pokemon
    }

    public JPanel initComponents() {
        // JPanel donde iniciamos y almacenamos todos los valores
        JPanel panel = new JPanel(new BorderLayout());

        // Panel central que almacena los dos Pokemon
        JPanel panelPokemon = new JPanel(new BorderLayout());

        panelPokemon.add(createPokemon(pActual, barrap1), BorderLayout.WEST); //Panel del Pokemon del Usuario
        panelPokemon.add(createPokemon(pCPU, barrap2), BorderLayout.EAST); //Panel del Pokemon de la CPU

        // Panel inferior para los botones de movimientos
        JPanel panelBotones = createAttackButton(pActual.getMovimientos(), panelPokemon);

        // Agrega el equipo del usuario y otros paneles
        panel.add(createTeam(teamUser, panelPokemon, panelBotones), BorderLayout.WEST);
        panel.add(panelPokemon, BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        return panel;
    }


    public JPanel createAttackButton(Movimiento[] moves, JPanel panelPokemon) {
        // Creacion de botones de Ataques
        Batalla battle = new Batalla(pActual, pCPU); //Iniciacion de batalla para poder gestionar los movimientos
        JPanel panel = new JPanel(); // JPanel donde se almacenan los movimientos
        //Creacion de todos los botones según cuántos ataques tenga el pokemon
        for (int i = 0; i < moves.length; i++) {
            int indice = i; // auxiliar para el manejo en los movimientos
            JButton ataque = new JButton(moves[i].getNombre()); // Crea el boton del ataque
            //Añade el Listener para cuando le clickan que use el ataque
            ataque.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Empieza la accion y calcula la mejor Opcion que puede elegir la CPU para golpearte
                    Movimiento movimientoCPU = battle.calcularMejorOpcion(pCPU.getMovimientos());
                    //Consigue el orden en el que se seleccionará el ataque
                    int orden = battle.ordenAtaques(moves[indice], movimientoCPU);

                    if (orden == 1) {
                        //Si gana el Orden el Usuario ataca el usuario y reduce la vida del CPU
                        reducirHP(barrap2, pCPU, battle.calculoDano(moves[indice], pActual, pCPU));
                        if (!comprobarVictoriaJugador(barrap2, teamCPU, panelPokemon, barrap2)) {//Comprueba si ha ganado el Usuario
                            //Si el pokemon del CPU no ha sido debilitado atacará la CPU y reducira la vida del Usuario
                            reducirHP(barrap1, pActual, battle.calculoDano(movimientoCPU, pCPU, pActual));
                            comprobarVictoriaCPU(barrap1, teamUser, panelPokemon, panel);//Comprueba si ha ganado el CPU
                        }
                    } else {
                        //Si gana el Orden el CPU ataca y reduce la vida del Usuario
                        reducirHP(barrap1, pActual, battle.calculoDano(movimientoCPU, pCPU, pActual));
                        if (!comprobarVictoriaCPU(barrap1, teamUser, panelPokemon, panel)) {//Comprueba si ha ganado el CPU
                            //Si el pokemon del Usuario no ha sido debilitado atacará y reducira la vida del CPU
                            reducirHP(barrap2, pCPU, battle.calculoDano(moves[indice], pActual, pCPU));
                            comprobarVictoriaJugador(barrap2, teamCPU, panelPokemon, barrap2);//Comprueba si ha ganado el Usuario
                        }
                    }
                }
            });
            panel.add(ataque);//Añade el boton
        }
        return panel;
    }

    public JPanel createPokemon(Pokemon p, JProgressBar barraHP) {
        JPanel panelPokemon = new JPanel(new BorderLayout());
        //Pone el nombre del pokemon
        JLabel label = new JLabel(p.getNombre());

        //Crea la imagen y la pone
        JLabel imagen = new JLabel();
        ImageIcon icon = new ImageIcon("src/main/java/com/Recursos/pokemonImages/" + p.getEspecie().toLowerCase() + ".png");
        Icon image = new ImageIcon(icon.getImage().getScaledInstance(200,230,Image.SCALE_SMOOTH));
        imagen.setIcon(image);

        //Añade la imagen y el nombre
        panelPokemon.add(label, BorderLayout.NORTH); // El nombre
        label.setHorizontalAlignment(SwingConstants.CENTER);

        panelPokemon.add(imagen, BorderLayout.CENTER); // La imagen
        imagen.setHorizontalAlignment(SwingConstants.CENTER);

        panelPokemon.add(barraHP, BorderLayout.SOUTH); // Añade la barra de vida

        return panelPokemon;
    }

    public JProgressBar createBarraHP(Pokemon p) {
        // Crea la barra de Vida segun el pokemon
        JProgressBar barraHP = new JProgressBar(0, p.getHp());
        barraHP.setValue(p.getHp()); //Settea el valor
        barraHP.setMaximum(p.getHp());//Settea el maximo

        barraHP.setStringPainted(true);
        barraHP.setBackground(p.getColorType());//Le pone el color segun su tipo
        barraHP.setBorder(new LineBorder(Color.BLACK, 2));//Pone el borde

        barraHP.setPreferredSize(new Dimension(300, barraHP.getPreferredSize().height));//Pone el tamaño que queremos

        return barraHP;
    }

    public void reducirHP(JProgressBar barra, Pokemon p, int cantidad) {
        p.setHp(p.getHp() - cantidad); //Se reduce la vida del Pokemon
        barra.setValue(p.getHp());//Se reduce la barra de vida del Pokemon
    }

    public int calculoHP(Pokemon p) {
        return (int) (((double) (2 * p.getHp()) / 100) * 50 + 50 + 10); //Calcula la estadistica de vida del Pokemon
    }

    public boolean comprobarVictoriaJugador(JProgressBar barra, ArrayList<Pokemon> equipoCPU, JPanel panelPokemon,
                                            JProgressBar barrap2) {
        if (barra.getValue() <= 0) {
            // Si el pokemon CPU se queda sin vida buscara el siguiente pokemon vivo de la cpu y lo empezará a usar la CPU
            boolean reemplazado = false;
            for (int i = 0; i < equipoCPU.size(); i++) {
                if (equipoCPU.get(i).getHp() > 0) {
                    //Si el pokemon está vivo lo seleccionara
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
            //Si no quedan pokemon vivos se acaba el combate y antes te Felicitan por tu victoria
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
            //Si no tienes pokemon vivos te muestra el mensaje de que has perdido y cierra la aplicacion
            if (pokemonVivos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "¡El CPU ha ganado la batalla! Todos tus Pokémon han sido debilitados.",
                        "FIN", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            //En caso de que nos queden algun Pokemon vivo nos enseñará una ventana con cual de estos Pokemon querremos usar
            String[] opcionesPokemon = pokemonVivos.stream().map(Pokemon::getNombre).toArray(String[]::new);
            int seleccion = JOptionPane.showOptionDialog(null, "Elige tu siguiente Pokémon",
                    "Cambio de Pokémon", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, opcionesPokemon, opcionesPokemon[0]);
            //Si no elegimos uno nos exigira una respuesta valida a la seleccion
            while (seleccion < 0) {
                seleccion = JOptionPane.showOptionDialog(null, "Tienes que elegir un Pokemon",
                        "Cambio de Pokémon", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, opcionesPokemon, opcionesPokemon[0]);
            }
            //Cambia el pokemon segun la seleccion y repinta el panel
            Pokemon seleccionado = pokemonVivos.get(seleccion);
            pActual = seleccionado;
            repinta(panelPokemon, panelBotones);
            // Cambia la barra de HP a la del pokemon nuevo
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
        //Comprueba cuantos pokemon tenemos
        for (int i = 0; i < listaPokemon.size(); i++) {
            //Crea el boton en cada pokemon que tenemos en el equipo
            JButton button = new JButton(listaPokemon.get(i).getNombre());
            int indice = i; //Gestion auxiliar para los Listeners que crearemos abajo para gestionar los cambios de Pokemon
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (listaPokemon.get(indice) == pActual) {//Si el pokemon es el mismo que el activo rechaza el cambio
                        JOptionPane.showMessageDialog(null, listaPokemon.get(indice).getNombre() + " esta en combate");
                    } else {
                        //Si no es el mismo y esta debilitado nos rechazara tambien el cambio
                        if (listaPokemon.get(indice).getHp() <= 0) {
                            JOptionPane.showMessageDialog(null, listaPokemon.get(indice).getNombre() + " esta debilitado");
                        } else {
                            //En caso de que tenga vida restante y no es el mismo cambiara el pokemon, lo repintará y el rival nos atacará
                            Batalla bAux = new Batalla(pActual, pCPU);
                            Movimiento m = bAux.calcularMejorOpcion(pCPU.getMovimientos()); //Coge la mejor opcion para atacar
                            // Cambia el Pokémon actual y lo repinta
                            pActual = listaPokemon.get(indice);
                            barrap1.setMaximum(hpEquipo[indice]);
                            barrap1.setValue(listaPokemon.get(indice).getHp());
                            barrap1.setForeground(pActual.getColorType());

                            repinta(panelPokemon, panelBotones);
                            // Reduce el HP y comprueba la victoria de la CPU
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
        int[] baseHP = new int[listaPokemon.size()];//Crea el Array con la vida maxima de los Pokemon
        for (int i = 0; i < listaPokemon.size(); i++) {
            //Pone en el array la vida del Pokemon
            baseHP[i] = calculoHP(listaPokemon.get(i));
            listaPokemon.get(i).setHp(baseHP[i]); //Settea la vida del Pokemon con su nuevo valor
        }
        return baseHP;
    }

    public void repinta(JPanel panelPokemon, JPanel panelBotones) {
        //Actualiza el panel del Pokemon
        panelPokemon.removeAll();
        panelPokemon.add(createPokemon(pActual, barrap1), BorderLayout.WEST);
        panelPokemon.add(createPokemon(pCPU, barrap2), BorderLayout.EAST);
        panelPokemon.revalidate();
        panelPokemon.repaint();
        //Actualiza los Botones
        panelBotones.removeAll();
        JPanel nuevosBotones = createAttackButton(pActual.getMovimientos(), panelPokemon);
        panelBotones.add(nuevosBotones);
        panelBotones.revalidate();
        panelBotones.repaint();
    }
}


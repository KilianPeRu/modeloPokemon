/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.PokemonContainer;

import com.BattleCPU.resources.Movimiento;
import com.BattleCPU.resources.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author exosh
 */
public class pokeComparator extends javax.swing.JFrame {
    Pokemon pokeCaja;
    Pokemon pokeComp;

    /**
     * Creates new form pokeComparator
     */
    public pokeComparator(Pokemon pCaja, ArrayList<Pokemon> pEquipo) {
        this.pokeCaja = pCaja;
        this.pokeComp = pEquipo.getFirst();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardContainer = new JPanel(new CardLayout());
        add(cardContainer, java.awt.BorderLayout.SOUTH);
        Splitter = new JPanel(new GridLayout(1, 2, 10, 10));
        pCaja = generatePokemon(pokeCaja);
        pEquipo = generatePokemon(pokeComp);
        cardContainer.setVisible(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pCaja.setPreferredSize(new Dimension(380, 484));
        pEquipo.setPreferredSize(new Dimension(380, 484));
        Splitter.add(pCaja);
        Splitter.add(pEquipo);

        getContentPane().add(Splitter, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout SplitterLayout = new javax.swing.GroupLayout(Splitter);
        Splitter.setLayout(SplitterLayout);
        SplitterLayout.setHorizontalGroup(
            SplitterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SplitterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(pCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        SplitterLayout.setVerticalGroup(
            SplitterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        revalidate();
        repaint();
    }// </editor-fold>//GEN-END:initComponents
    public JPanel generatePokemon(Pokemon p){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //Genera el top
        panel.add(new JLabel(p.getNombre()), BorderLayout.NORTH);

        //Genera la imagen
        ImageIcon icon = new ImageIcon("src/main/java/com/Recursos/pokemonImages/" + p.getEspecie().toLowerCase() + ".png");
        Icon image = new ImageIcon(icon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        panel.add(new JLabel(image), BorderLayout.CENTER);

        //Genera el panel inferior
        JPanel panelMovimientos = new JPanel(new GridLayout(2, 2));
        for (Movimiento m : p.getMovimientos()) {
            cardContainer.add(generatePanelMove(m), m.getNombre());
            JButton bttn = new JButton(m.getNombre());
            CardLayout cl = (CardLayout) cardContainer.getLayout();
            bttn.addActionListener(e -> {
                cl.show(cardContainer, m.getNombre());
                cardContainer.setVisible(true);
            });
            bttn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    cl.show(cardContainer, m.getNombre());
                    cardContainer.setVisible(true);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    cardContainer.setVisible(false);
                }
            });
            panelMovimientos.add(bttn);
        }
        panel.add(panelMovimientos, BorderLayout.SOUTH);

        return panel;
    }
    public JPanel generatePanelMove(Movimiento m){
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Potencia");
        JLabel potencia = new JLabel(String.valueOf(m.getPoder()));
        JLabel label1 = new JLabel("Precision");
        JLabel precision = new JLabel(String.valueOf(m.getPrecision()));
        JLabel label2 = new JLabel("Clase");
        JLabel clase = new JLabel(String.valueOf(m.getClase()));
        JLabel label3 = new JLabel("Tipo");
        JLabel tipo = new JLabel(String.valueOf(m.getTipo()));
        panel.add(label);
        panel.add(potencia);
        panel.add(label1);
        panel.add(precision);
        panel.add(label2);
        panel.add(clase);
        panel.add(label3);
        panel.add(tipo);

        panel.setBackground(m.getColorType());
        return panel;
    }
    JPanel cardContainer;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Splitter;
    private javax.swing.JPanel pCaja;
    private javax.swing.JPanel pEquipo;
    // End of variables declaration//GEN-END:variables
}

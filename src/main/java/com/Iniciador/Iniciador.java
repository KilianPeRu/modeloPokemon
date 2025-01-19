package com.Iniciador;

import com.BattleCPU.gui.pokemonInterface;

import javax.swing.*;

public class Iniciador {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new pokemonInterface());
        frame.pack();
        frame.setVisible(true);
    }
}

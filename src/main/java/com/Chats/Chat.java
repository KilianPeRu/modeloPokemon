package com.Chats;

import com.PokemonContainer.PokemonContainerGUI;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

public class Chat extends javax.swing.JFrame implements Observer {
    private String username;
    private int friendPort;
    private Servidor server;
    private String friendName;

    public Chat(String username, int myPort, int friendPort, String friendName) {
        this.friendName = friendName;
        this.username = username;
        this.friendPort = friendPort;
        initComponents();
        this.getRootPane().setDefaultButton(this.btnEnviar);
        txtTexto.setFocusable(false);
        // Iniciar servidor en el puerto asignado
        server = new Servidor(myPort);
        server.addObserver(this);
        Thread t = new Thread(server);
        t.start();
        addKeyListeners();
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                String msg = "Sistema : El usuario" + username + " se ha desconectado";
                Cliente c = new Cliente(friendPort, msg);
                Thread t = new Thread(c);
                t.start();
            }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtTexto = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        txtTextoEnviar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(username + " - " + friendName);

        txtTexto.setColumns(20);
        txtTexto.setRows(5);
        jScrollPane1.setViewportView(txtTexto);

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTextoEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(txtTextoEnviar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {
        String mensaje = username + ": " + this.txtTextoEnviar.getText() + "\n";
        if(!txtTextoEnviar.getText().trim().equals("")) {
            // Enviar al puerto del amigo
            Cliente c = new Cliente(friendPort, mensaje);
            Thread t = new Thread(c);
            t.start();

            this.txtTextoEnviar.setText(""); // Limpiar campo de texto
            this.txtTexto.append(mensaje);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtTexto;
    private javax.swing.JTextField txtTextoEnviar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        String mensaje = (String) arg;
        String auxiliar[] = mensaje.split(":");
        String usuario = auxiliar[0];
        if (!usuario.equals(this.username) || mensaje.contains(username+":")) {
            this.txtTexto.append(mensaje);
        }
    }

    public void addKeyListeners() {
        KeyListener enterKeyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // No utilizado
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                   // btnEnviarActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "EnterKeyPressed"));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No utilizado
            }
        };
        txtTextoEnviar.addKeyListener(enterKeyListener);
    }
}

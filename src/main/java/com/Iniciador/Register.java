/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.Iniciador;

import com.BattleCPU.resources.Pokemon;
import com.Recursos.CargarEquipoRival;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.TimerTask;

/**
 *
 * @author exosh
 */
public class Register extends JFrame {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Javamon";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        buttn = new JButton();
        inicialBox = new JComboBox<>();
        jLabel4 = new JLabel();
        jLabel3 = new JLabel();
        passField = new JTextField();
        userField = new JTextField();
        jLabel2 = new JLabel();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        buttn.setText("REGISTRARSE");
        buttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttnActionPerformed(evt);
            }
        });

        inicialBox.setModel(new DefaultComboBoxModel<>(new String[] { "Pikachu", "Charmander", "Bulbasaur", "Squirtle" }));
        inicialBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            }
        });

        jLabel4.setText("Pokemon Inicial:");

        jLabel3.setText("Contraseña:");

        userField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                userFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre de Usuario:");

        jLabel1.setFont(new Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("REGISTRO");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(inicialBox, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passField, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userField, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))))
                        .addGap(14, 14, 14))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(inicialBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(25, 25, 25)
                .addComponent(buttn)
                .addGap(0, 61, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    
    private void buttnActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(registerUser(userField.getText(),passField.getText())){
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Usuario no registrado");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void userFieldActionPerformed(ActionEvent evt) {//GEN-FIRST:event_userFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userFieldActionPerformed
    private boolean registerUser(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String checkQuery = "SELECT * FROM users WHERE name = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, username);

            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                return false;
            }

            String insertQuery = "INSERT INTO users (name, passwd) VALUES (?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setString(1, username);
            insertStmt.setString(2, password);
            insertStmt.executeUpdate();
            conn.setAutoCommit(false);
            conn.commit();
            String id = null;
            String getID = "SELECT idUsuario FROM users WHERE `name` LIKE '" + username + "'";
            PreparedStatement getStmt = conn.prepareStatement(getID);
            ResultSet az = getStmt.executeQuery();
            if (az.next()) {
                id = az.getString("idUsuario");
            }
            CargarEquipoRival c = new CargarEquipoRival();
            System.out.println(id);

            ArrayList<Pokemon> listAux = c.cargarEquipo("usergestor");
            for (Pokemon p : listAux) {
                if(p.getNombre().equals(inicialBox.getSelectedItem().toString())){
                    String aux;
                    if(p.getTipo2().equals("")) {
                        aux = "null";
                    } else{
                        aux = p.getTipo2();
                    }
                    System.out.println(p.getNombre());
                    insertQuery = "INSERT INTO pokemon (idTrainer,trainerName,`name`, specie,type1,type2,hp,atk,def,eAtk,eDef,spd,team,move1,move2,move3,move4)" +
                            " VALUES "+"("+id + ",'"+ username + "','"+ p.getNombre() + "','"+ p.getEspecie()+"','"+p.getTipo1()+"','"+aux+"',"+
                            p.getHp()+","+p.getAtq()+","+p.getDef()+","+p.getEat()+","+p.getEdf()+","+p.getVel()+ "," + "true"+","+
                            p.getM1()+","+p.getM2()+","+p.getM3()+","+p.getM4()+")";
                    insertStmt = conn.prepareStatement(insertQuery);
                    insertStmt.executeUpdate();
                    conn.commit();

                }
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton buttn;
    private JComboBox<String> inicialBox;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JTextField passField;
    private JTextField userField;
    // End of variables declaration//GEN-END:variables
}

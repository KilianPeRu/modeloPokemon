/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.Iniciador;

import com.BattleCPU.resources.CargarEquipoRival;
import com.BattleCPU.resources.Pokemon;
import com.BattleCPU.resources.mainPeleasAlpha;
import com.Recursos.Modifiers.RoundBorder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author exosh
 */
public class initialMenu extends javax.swing.JFrame {
    CargarEquipoRival cargarEquipoRival = new CargarEquipoRival();
    ArrayList<Pokemon> listaEquipo;
    JPanel equipo;
    /**
     * Creates new form initialMenu
     */
    public initialMenu(String username, String passwd) throws SQLException, ClassNotFoundException {
        listaEquipo = cargarEquipoRival.cargarEquipo(username);
        initComponents();
        iniciar();
        initializeGUI();
        setVisible(true);
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        top = new javax.swing.JPanel();
        userProfile = new javax.swing.JPanel();
        userName = new javax.swing.JLabel();
        userID = new javax.swing.JButton();
        image = new javax.swing.JButton();
        settings = new javax.swing.JButton();
        menu = new javax.swing.JPanel();
        buttonPC = new javax.swing.JButton();
        buttonShop = new javax.swing.JButton();
        buttonChat = new javax.swing.JButton();
        buttonBattle = new javax.swing.JButton();
        buttonCPU = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        userName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userName.setText("name");

        userID.setBackground(userProfile.getBackground());
        userID.setText("uuid");
        userID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIDActionPerformed(evt);
            }
        });

        image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userProfileLayout = new javax.swing.GroupLayout(userProfile);
        userProfile.setLayout(userProfileLayout);
        userProfileLayout.setHorizontalGroup(
            userProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(userProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userID, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addContainerGap())
        );
        userProfileLayout.setVerticalGroup(
            userProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userProfileLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(userName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userID)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(userProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 718, Short.MAX_VALUE)
                .addComponent(userProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        topLayout.setVerticalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(settings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(top, java.awt.BorderLayout.PAGE_START);

        buttonPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPCActionPerformed(evt);
            }
        });

        buttonShop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShopActionPerformed(evt);
            }
        });

        buttonChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChatActionPerformed(evt);
            }
        });

        buttonBattle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBattleActionPerformed(evt);
            }
        });

        buttonCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    buttonCPUActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addComponent(buttonPC, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonShop, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addComponent(buttonChat, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonBattle, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonShop, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPC, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonChat, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBattle, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(menu, java.awt.BorderLayout.WEST);
        menu.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void iniciar() {
        equipo = loadTeam(listaEquipo);
        add(equipo, BorderLayout.EAST);
    }
    public JPanel loadTeam(ArrayList<Pokemon> equipoPokemon) {
        JPanel team = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 10, 5, 5); // 5px de padding en todos los lados

        for (int i = 0; i < equipoPokemon.size(); i++) {
            gbc.gridx = 0; // Mantenemos la columna en 0
            gbc.gridy = i; // Incrementamos la fila para cada Pokémon

            JButton bttn = new JButton();
            bttn.setPreferredSize(new Dimension(100, menu.getHeight() / equipoPokemon.size() - 10));
            ImageIcon icon = new ImageIcon("src/main/java/com/Recursos/pokemonImages/" + equipoPokemon.get(i).getEspecie().toLowerCase() + ".png");
            Icon image = new ImageIcon(icon.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
            bttn.setIcon(image);
            bttn.setBorder(new RoundBorder(9));
            bttn.setBorder(BorderFactory.createCompoundBorder(new RoundBorder(9), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
            team.add(bttn, gbc);
        }

        return team;
    }

    private void settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_settingsActionPerformed

    private void userIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIDActionPerformed
        // TODO add your handling code here:
        StringSelection seleccion = new StringSelection(userID.getText());
        Clipboard portapapeles = Toolkit.getDefaultToolkit().getSystemClipboard();
        portapapeles.setContents(seleccion, null);

        // Mostrar un mensaje de confirmación
        JOptionPane.showMessageDialog(null, "Texto copiado al portapapeles.");
    }//GEN-LAST:event_userIDActionPerformed

    private void buttonPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPCActionPerformed
        // TODO add your handling code here:
        weAreWorking();
    }//GEN-LAST:event_buttonPCActionPerformed

    private void buttonShopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShopActionPerformed
        // TODO add your handling code here:
        weAreWorking();
    }//GEN-LAST:event_buttonShopActionPerformed

    private void buttonChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChatActionPerformed
        // TODO add your handling code here:
        weAreWorking();
    }//GEN-LAST:event_buttonChatActionPerformed

    private void buttonBattleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBattleActionPerformed
        // TODO add your handling code here:
        weAreWorking();
    }//GEN-LAST:event_buttonBattleActionPerformed

    private void buttonCPUActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, ClassNotFoundException {//GEN-FIRST:event_buttonCPUActionPerformed
        // TODO add your handling code here:
        new mainPeleasAlpha();
        dispose();
    }//GEN-LAST:event_buttonCPUActionPerformed

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        // TODO add your handling code here:
        weAreWorking();
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void imageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imageActionPerformed

    private void initializeGUI() {
        //Setteo de iconos para hoverManager
        Icon iconsettings = getIcono("src/main/java/com/Recursos/utils/engranaje.png");
        Icon iconCPU = getIcono("src/main/java/com/Recursos/utils/logoCPU.png");
        Icon iconBattle = getIcono("src/main/java/com/Recursos/utils/onlineBattle.png");

        //Imagen del boton de settings
        settings.setIcon(getIcono("src/main/java/com/Recursos/utils/engranaje.png",settings.getWidth(),settings.getHeight()));
        settings.setBorderPainted(false);
        settings.setContentAreaFilled(false);
        settings.setFocusPainted(false);
        settings.setOpaque(false);

        //Imagen del boton de la pelea del CPU
        buttonCPU.setIcon(getIcono("src/main/java/com/Recursos/utils/logoCPU.png",buttonCPU.getWidth(),buttonCPU.getHeight()));
        buttonCPU.setBorder(new LineBorder(Color.BLACK,2));
        buttonCPU.addMouseListener(hoverManager(buttonCPU, iconCPU));
        //Imagen del boton de la pelea Online
        buttonBattle.setIcon(getIcono("src/main/java/com/Recursos/utils/onlineBattle.png",buttonBattle.getWidth(),buttonBattle.getHeight()));
        buttonBattle.setBorder(new LineBorder(Color.BLACK,2));
        buttonBattle.addMouseListener(hoverManager(buttonBattle, iconBattle));

    }
    public MouseAdapter hoverManager(JButton button, Icon icon){
        MouseAdapter hover = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setIcon(focusManager(button.getIcon(), 0.3f));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setIcon(icon);
            }
        };
        return hover;
    }
    public Icon getIcono(String ruta){
        ImageIcon icon = new ImageIcon(ruta);
        icon.setImage(icon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        return icon;
    }
    public Icon getIcono(String ruta, int width, int height){
        ImageIcon icon = new ImageIcon(ruta);
        icon.setImage(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        return icon;
    }
    //Mode 1: Lighter     | |             Mode 2: Darker
    public Icon focusManager(Icon imagen, float force) {
        int width = imagen.getIconWidth();
        int height = imagen.getIconHeight();

        // Crear una imagen compatible
        Image translator = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) translator.getGraphics();

        // Dibujar el icono original en la imagen
        imagen.paintIcon(null, g2d, 0, 0);

        // Dibujar un filtro oscuro
        g2d.setComposite(AlphaComposite.SrcAtop.derive(force));
            g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, width, height);

        g2d.dispose();

        // Retornar un nuevo Icon basado en la imagen
        return new ImageIcon(translator);
    }
    public void weAreWorking(){
        SwingUtilities.invokeLater(() -> {
            // Crear un panel con la imagen
            ImageIcon icon = new ImageIcon("src/main/java/com/Recursos/utils/engranaje.png"); // Cambia la ruta según tu imagen
            JLabel label = new JLabel("Estamos trabajando...", icon, JLabel.CENTER);
            label.setHorizontalTextPosition(SwingConstants.CENTER);
            label.setVerticalTextPosition(SwingConstants.BOTTOM);

            // Mostrar el JOptionPane
            JOptionPane pane = new JOptionPane(label, JOptionPane.PLAIN_MESSAGE,JOptionPane.PLAIN_MESSAGE);

            JDialog dialog = pane.createDialog("Working...");
            dialog.setModal(false);
            dialog.setVisible(true);

            // Crear un temporizador para cerrar el cuadro
            new javax.swing.Timer(2000, e -> dialog.dispose()).start();
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBattle;
    private javax.swing.JButton buttonCPU;
    private javax.swing.JButton buttonChat;
    private javax.swing.JButton buttonPC;
    private javax.swing.JButton buttonShop;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JButton image;
    private javax.swing.JPanel menu;
    private javax.swing.JButton settings;
    private javax.swing.JPanel top;
    private javax.swing.JButton userID;
    private javax.swing.JLabel userName;
    private javax.swing.JPanel userProfile;
    // End of variables declaration//GEN-END:variables
}

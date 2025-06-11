package com.Chats;

import javax.swing.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente implements Runnable {

    private int puerto;
    private String mensaje;

    public Cliente(int puerto, String mensaje) {
        this.puerto = puerto;
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        //Host del servidor
        final String HOST = "localhost";
        //Puerto del servidor
        DataOutputStream out;
        Socket sc = null;
        try {
            //Creo el socket para conectarme con el cliente
            sc = new Socket(HOST, puerto);

            out = new DataOutputStream(sc.getOutputStream());

            //Envio un mensaje al cliente
            out.writeUTF(mensaje);

            sc.close();

        } catch (IOException ex) {
            String[] aux = mensaje.split(":");
            if (!aux[0].equals("Sistema ")) {
                JDialog dialog = new JDialog();
                dialog.setTitle("Error");
                JOptionPane.showMessageDialog(dialog, "Usuario desconectado");
            }
        }

    }
}

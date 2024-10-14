package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            AñadirUsuario ventana = new AñadirUsuario();
            ventana.setVisible(true);
        });
    }
}
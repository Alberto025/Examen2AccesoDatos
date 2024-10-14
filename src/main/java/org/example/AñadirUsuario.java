package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AñadirUsuario extends JFrame {
    private JPanel mainPanel;
    private JTextField txtCorreo;
    private JComboBox<String> comboPais;
    private JComboBox<String> comboPlataforma;
    private JButton btnConfirmar;
    private JButton btnVolver;
    private JLabel lblInfo;
    private JTable tablaUsuarios;
    private DefaultTableModel modeloTabla;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton confirmarYGuardarButton;
    private JButton volverAtrásButton;
    private JTable table1;

    public AñadirUsuario() {
        // Configuración de la ventana principal
        setTitle("Añadir Usuario");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        setContentPane(mainPanel);

        // Panel para el formulario de entrada
        JPanel formularioPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formularioPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formularioPanel.add(new JLabel("Correo:"));
        txtCorreo = new JTextField();
        formularioPanel.add(txtCorreo);

        formularioPanel.add(new JLabel("País:"));
        comboPais = new JComboBox<>(new String[]{"Argentina", "Brasil", "Chile", "España", "México"});
        formularioPanel.add(comboPais);

        formularioPanel.add(new JLabel("Plataforma:"));
        comboPlataforma = new JComboBox<>(new String[]{"Escritorio", "Móvil", "Desconocido"});
        formularioPanel.add(comboPlataforma);

        // Botones de acción
        btnConfirmar = new JButton("Confirmar");
        btnVolver = new JButton("Volver");
        formularioPanel.add(btnConfirmar);
        formularioPanel.add(btnVolver);

        mainPanel.add(formularioPanel, BorderLayout.NORTH);

        // Tabla para mostrar usuarios
        modeloTabla = new DefaultTableModel(new Object[]{"Correo", "País", "Plataforma"}, 0);
        tablaUsuarios = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Label para mensajes de actividad
        lblInfo = new JLabel(" ");
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(lblInfo, BorderLayout.SOUTH);


        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarUsuario();
            }
        });


        btnVolver.addActionListener(e -> {
            dispose();
        });
    }

    // Método para agregar un usuario a la tabla
    private void agregarUsuario() {
        String correo = txtCorreo.getText().trim();
        String pais = (String) comboPais.getSelectedItem();
        String plataforma = (String) comboPlataforma.getSelectedItem();

        if (correo.isEmpty() || pais == null || plataforma == null) {
            lblInfo.setText("Falta algún campo por completar.");
        } else {
            // Agregar datos a la tabla
            modeloTabla.addRow(new Object[]{correo, pais, plataforma});
            lblInfo.setText("Usuario agregado correctamente.");

            // Mostrar mensaje de confirmación
            JOptionPane.showMessageDialog(this, "Usuario almacenado correctamente: " + correo);

            // Limpiar los campos del formulario
            txtCorreo.setText("");
            comboPais.setSelectedIndex(0);
            comboPlataforma.setSelectedIndex(0);
        }
    }


}

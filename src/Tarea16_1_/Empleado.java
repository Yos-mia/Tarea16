package Tarea16_1_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Empleado {
    private JFrame frame;
    private JTextField txtNombre, txtApellido, txtFecha;
    private JTextArea txtAreaEmpleados;
    private ArrayList<String> empleados;

    public Empleado() {
        empleados = new ArrayList<>();

        frame = new JFrame("Registro de Empleados");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLayout(null); // Usamos null para colocar componentes manualmente

        JLabel lblNombre = new JLabel("NOMBRE:");
        lblNombre.setBounds(20, 20, 100, 25);
        frame.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 20, 200, 25);
        frame.add(txtNombre);

        JLabel lblApellido = new JLabel("APELLIDO:");
        lblApellido.setBounds(20, 60, 100, 25);
        frame.add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setBounds(150, 60, 200, 25);
        frame.add(txtApellido);

        JLabel lblFecha = new JLabel("FECHA DE NACIMIENTO:");
        lblFecha.setBounds(20, 100, 150, 25);
        frame.add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setBounds(150, 100, 200, 25);
        frame.add(txtFecha);

        JButton btnGuardar = new JButton("ACEPTAR");
        btnGuardar.setBounds(150, 140, 100, 30);
        frame.add(btnGuardar);

        txtAreaEmpleados = new JTextArea();
        txtAreaEmpleados.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaEmpleados);
        scrollPane.setBounds(20, 180, 340, 120);
        frame.add(scrollPane);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String empleado = txtNombre.getText() + " " + txtApellido.getText() + " (" + txtFecha.getText() + ")";
                if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtFecha.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.");
                    return;
                }
                empleados.add(empleado);
                actualizarListaEmpleados();
                limpiarCampos();
            }
        });

        frame.setVisible(true);
    }

    private void actualizarListaEmpleados() {
        txtAreaEmpleados.setText("");
        for (String emp : empleados) {
            txtAreaEmpleados.append(emp + "\n");
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtFecha.setText("");
    }

    public static void main(String[] args) {
        new Empleado();
    }
}
package UI;

import javax.swing.*;
import java.awt.*;
import Logic.Funcionamiento_parqueadero;
import Model.*;

public class Correr_parqueadero {
    private static Funcionamiento_parqueadero corparq = new Funcionamiento_parqueadero();
    private static String tipo, marca, placa;
    private static int contraseña;

    public static void main(String[] args) {
        ingresarDatos();
        ingresarContraseñaAdmin();
        asignarContrato();
    }

    private static void ingresarDatos() {
        // Crear un panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1)); // 6 filas, 1 columna

        // Etiqueta y campo de texto para el tipo de vehículo
        JLabel tipoLabel = new JLabel("Tipo de Vehiculo:");
        JTextField tipoTextField = new JTextField(10); // Ancho del campo de texto
        panel.add(tipoLabel);
        panel.add(tipoTextField);

        // Etiqueta y campo de texto para la placa
        JLabel placaLabel = new JLabel("Placa:");
        JTextField placaTextField = new JTextField(10); // Ancho del campo de texto
        panel.add(placaLabel);
        panel.add(placaTextField);

        // Etiqueta y campo de texto para la marca
        JLabel marcaLabel = new JLabel("Marca:");
        JTextField marcaTextField = new JTextField(10); // Ancho del campo de texto
        panel.add(marcaLabel);
        panel.add(marcaTextField);

        // Cambiar el color de fondo del panel
        panel.setBackground(Color.YELLOW);

        // Establecer el tamaño preferido del panel
        panel.setPreferredSize(new Dimension(400, 300));

        // Mostrar el panel en un JOptionPane
        int result = JOptionPane.showConfirmDialog(null, panel, "Ingrese información del vehículo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Obtener la información ingresada si se presionó OK
        if (result == JOptionPane.OK_OPTION) {
            tipo = tipoTextField.getText();
            placa = placaTextField.getText();
            marca = marcaTextField.getText();
            JOptionPane.showMessageDialog(null, "Información del vehículo ingresada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void ingresarContraseñaAdmin() {
        contraseña = corparq.generarContraseña();
        JPanel panel = new JPanel();
        JLabel contraLabel = new JLabel("Contraseña del administrador: " + contraseña);
        JTextField contraText = new JTextField(5);
        panel.add(contraLabel);
        panel.add(contraText);
    }

    private static void asignarContrato() {
        JPanel panel = new JPanel();
        JLabel tipoLabel = new JLabel("Tipo de Vehiculo:");
        JTextField tipoTextField = new JTextField(10);
        JLabel placaLabel = new JLabel("Placa:");
        JTextField placaTextField = new JTextField(10);
        JLabel marcaLabel = new JLabel("Marca:");
        JTextField marcaTextField = new JTextField(10);
        panel.setLayout(new GridLayout(6, 1));
        panel.add(tipoLabel);
        panel.add(tipoTextField);
        panel.add(placaLabel);
        panel.add(placaTextField);
        panel.add(marcaLabel);
        panel.add(marcaTextField);
        panel.setBackground(Color.YELLOW);
        panel.setPreferredSize(new Dimension(400, 300));

        int result = JOptionPane.showConfirmDialog(null, panel, "Ingrese información del vehículo para contrato", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String tipoContrato = tipoTextField.getText();
            String placaContrato = placaTextField.getText();
            String marcaContrato = marcaTextField.getText();

            try {
                corparq.validarDatos(tipoContrato, placaContrato, marcaContrato);
                int puesto = corparq.asignarPuesto();
                Vehiculo vehiculo = new Vehiculo(tipoContrato, placaContrato, marcaContrato, puesto);
                corparq.parquearVehiculo(vehiculo);
                JOptionPane.showMessageDialog(null, "Contrato realizado exitosamente. El vehículo se ha parqueado correctamente en el puesto " + puesto + ".", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vehiculo;

/**
 *
 * @author Aleh
 */
// ==========================================

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaDelivery extends JFrame {

    // Componentes del Formulario
    private JButton btnCalcular;
    private JScrollPane scroll;
    
    private JTextField txtPeso, txtDistancia, txtTiempo;
    private JComboBox<String> comboVehiculo;
    
    // Componentes específicos del Drone
    private JTextField txtTipoDrone, txtCargaMax, txtBateria;
    private JCheckBox chkPiloto, chkRegistrado;
    
    // Componentes de salida
    private JTextArea txtResultado;

    public SistemaDelivery() {
        // Configuración básica de la ventana
        setTitle("Sistema de Servicios de Delivery");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(null); 
        setLocationRelativeTo(null); 

        int y = 20; 

        // --- DATOS GENERALES ---
        JLabel lblTitulo = new JLabel("REGISTRO DE ENVÍO", JLabel.CENTER);
        lblTitulo.setBounds(20, y, 480, 20);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblTitulo);
        
        y += 40;
        JLabel lblPeso = new JLabel("Peso del Paquete (kg):");
        lblPeso.setBounds(30, y, 180, 20);
        add(lblPeso);
        txtPeso = new JTextField();
        txtPeso.setBounds(220, y, 100, 20);
        add(txtPeso);

        y += 30;
        JLabel lblDistancia = new JLabel("Distancia (Km):");
        lblDistancia.setBounds(30, y, 180, 20);
        add(lblDistancia);
        txtDistancia = new JTextField();
        txtDistancia.setBounds(220, y, 100, 20);
        add(txtDistancia);

        y += 30;
        JLabel lblTiempo = new JLabel("Tiempo estimado (min):");
        lblTiempo.setBounds(30, y, 180, 20);
        add(lblTiempo);
        txtTiempo = new JTextField();
        txtTiempo.setBounds(220, y, 100, 20);
        add(txtTiempo);

        y += 30;
        JLabel lblVehiculo = new JLabel("Seleccionar Vehículo:");
        lblVehiculo.setBounds(30, y, 180, 20);
        add(lblVehiculo);
        
        String[] opciones = {"Carro", "Moto", "Drone"};
        comboVehiculo = new JComboBox<>(opciones);
        comboVehiculo.setBounds(220, y, 100, 20);
        add(comboVehiculo);

        // --- SECCIÓN ESPECÍFICA PARA DRONE ---
        y += 40;
        JLabel lblSeccionDrone = new JLabel("--- Condiciones Especiales (Solo para Drones) ---");
        lblSeccionDrone.setBounds(30, y, 400, 20);
        lblSeccionDrone.setForeground(Color.BLUE);
        add(lblSeccionDrone);

        y += 30;
        JLabel lblTipoD = new JLabel("Tipo de Drone (ej: Delivery):");
        lblTipoD.setBounds(30, y, 180, 20);
        add(lblTipoD);
        txtTipoDrone = new JTextField("Delivery");
        txtTipoDrone.setBounds(220, y, 100, 20);
        add(txtTipoDrone);

        y += 30;
        JLabel lblCargaM = new JLabel("Carga Máxima del vehículo (kg):");
        lblCargaM.setBounds(30, y, 180, 20);
        add(lblCargaM);
        txtCargaMax = new JTextField("15");
        txtCargaMax.setBounds(220, y, 100, 20);
        add(txtCargaMax);

        y += 30;
        JLabel lblBateria = new JLabel("Batería Disponible (%):");
        lblBateria.setBounds(30, y, 180, 20);
        add(lblBateria);
        txtBateria = new JTextField("100");
        txtBateria.setBounds(220, y, 100, 20);
        add(txtBateria);

        y += 30;
        chkPiloto = new JCheckBox("¿Piloto Certificado?");
        chkPiloto.setBounds(30, y, 180, 20);
        chkPiloto.setSelected(true);
        add(chkPiloto);

        chkRegistrado = new JCheckBox("¿Drone Registrado?");
        chkRegistrado.setBounds(220, y, 180, 20);
        chkRegistrado.setSelected(true);
        add(chkRegistrado);

        // --- BOTÓN DE PROCESAMIENTO ---
        y += 40;
        btnCalcular = new JButton("Calcular Servicio y Ver Ruta");
        btnCalcular.setBounds(30, y, 470, 30);
        add(btnCalcular);

        // --- ÁREA DE RESULTADOS ---
        y += 40;
        JLabel lblRes = new JLabel("Resultado del Reporte:");
        lblRes.setBounds(30, y, 200, 20);
        add(lblRes);

        y += 20;
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 12)); 
        
        scroll = new JScrollPane(txtResultado);
        scroll.setBounds(30, y, 470, 180);
        add(scroll);

        // --- ACCIÓN DEL BOTÓN ---
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double peso = Double.parseDouble(txtPeso.getText());
                    double distancia = Double.parseDouble(txtDistancia.getText());
                    double tiempo = Double.parseDouble(txtTiempo.getText());
                    double costoBase = 4000.0;

                    Vehiculo vehiculo = null;
                    String tipoSeleccionado = comboVehiculo.getSelectedItem().toString();

                    if (tipoSeleccionado.equals("Carro")) {
                        vehiculo = new Carro("Carro de Reparto Chevrolet", peso, tiempo, distancia, costoBase);
                    } 
                    else if (tipoSeleccionado.equals("Moto")) {
                        vehiculo = new Moto("Motocicleta Rápida Suzuki", peso, tiempo, distancia, costoBase);
                    } 
                    else if (tipoSeleccionado.equals("Drone")) {
                        String tipoD = txtTipoDrone.getText();
                        double cargaM = Double.parseDouble(txtCargaMax.getText());
                        boolean pilotoOk = chkPiloto.isSelected();
                        boolean droneOk = chkRegistrado.isSelected();
                        double bat = Double.parseDouble(txtBateria.getText());

                        vehiculo = new Drone("Dron Phantom Delivery", peso, tiempo, distancia, costoBase,
                                             tipoD, cargaM, pilotoOk, droneOk, bat);
                    }

                    if (vehiculo != null) {
                        if (vehiculo.validarCondicionesEntrega()) {
                            double costoFinal = vehiculo.calcularCostoServicio();
                            
                            String reporte = "=== REPORTE DE SERVICIO ===\n";
                            reporte += "Vehículo asignado: " + vehiculo.getNombreVehiculo() + "\n";
                            reporte += "Estado de entrega: PERMITIDO\n";
                            reporte += "Costo Total: $" + costoFinal + "\n\n";
                            reporte += "--- Matriz de Ubicación (Ruta de Entrega) ---\n";
                            reporte += generarMatrizRuta(); 
                            
                            txtResultado.setText(reporte);

                            // ==========================================================
                            // APERTURA DINÁMICA DE MAPAS SEGÚN EL VEHÍCULO SELECCIONADO
                            // ==========================================================
                            if (tipoSeleccionado.equals("Drone")) {
                                DroneRuta mapaDrone = new DroneRuta("Ruta de Vuelo - Drone", "mapa_drone.jpg", "Drone");
                                mapaDrone.setVisible(true);
                            } 
                            else if (tipoSeleccionado.equals("Carro")) {
                                DroneRuta mapaCarro = new DroneRuta("Ruta Vial - Carro", "mapa_carro.jpg", "Carro");
                                mapaCarro.setVisible(true);
                            } 
                            else if (tipoSeleccionado.equals("Moto")) {
                                DroneRuta mapaMoto = new DroneRuta("Ruta Rápida - Motocicleta", "mapa_moto.jpg", "Moto");
                                mapaMoto.setVisible(true);
                            }

                        } else {
                            txtResultado.setText("MENSANJE DE VALIDACIÓN:\n"
                                    + "¡ENTREGA RECHAZADA! El vehículo '" + tipoSeleccionado + "' no cumple\n"
                                    + "con las políticas de peso o condiciones de seguridad requeridas.");
                        }
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, 
                            "Error: Verifique que los campos numéricos no estén vacíos.", 
                            "Error de Datos", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private String generarMatrizRuta() {
        String[][] mapa = {
            {"[Origen]", "[ ]", "[ ]", "[ ]"},
            {"  [ ]  ", " [~]", " [ ]", " [ ]"},
            {"  [ ]  ", " [ ]", " [~]", "[Destino]"}
        };
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                sb.append(mapa[i][j]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SistemaDelivery ventana = new SistemaDelivery();
        ventana.setVisible(true);
    }
}

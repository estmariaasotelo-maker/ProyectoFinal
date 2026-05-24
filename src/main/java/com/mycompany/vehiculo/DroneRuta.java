/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vehiculo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DroneRuta extends JFrame {
    public DroneRuta(String titulo, String mapa, String tipo) {
        setTitle(titulo);
        setSize(700, 520);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new PanelRutaAnimado(mapa, tipo));
    }
}

class PanelRutaAnimado extends JPanel implements ActionListener {
    private Image fondo, icono;
    private String vehiculo;
    private int x, y;
    private int[][] puntos;
    private int indice = 0;
    private Timer timer;
    private double paso = 0.0;

    public PanelRutaAnimado(String mapa, String tipo) {
        this.vehiculo = tipo;
        try {
            fondo = new ImageIcon(getClass().getClassLoader().getResource(mapa)).getImage();
            icono = new ImageIcon(getClass().getClassLoader().getResource(tipo.toLowerCase() + "_icono.png")).getImage();
        } catch (Exception e) { System.out.println("Error carga: " + e.getMessage()); }

        if (tipo.equals("Drone")) puntos = new int[][]{ {100, 120}, {600, 120}, {600, 200}, {100, 200}, {100, 280}, {600, 280} };
        else if (tipo.equals("Carro")) puntos = new int[][]{ {120, 410}, {390, 410}, {390, 240}, {620, 240} };
        else puntos = new int[][]{ {150, 100}, {310, 240}, {450, 150}, {580, 380} };
        
        x = puntos[0][0]; y = puntos[0][1];
        timer = new Timer(30, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        if (puntos == null || indice >= puntos.length - 1) { timer.stop(); return; }
        paso += 0.03;
        if (paso >= 1.0) { paso = 0.0; indice++; }
        else {
            x = (int) (puntos[indice][0] + (puntos[indice+1][0] - puntos[indice][0]) * paso);
            y = (int) (puntos[indice][1] + (puntos[indice+1][1] - puntos[indice][1]) * paso);
        }
        repaint();
    }

   @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // 1. Dibujar el mapa de fondo
        if (fondo != null) {
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }

        Graphics2D g2d = (Graphics2D) g;
        // Activamos suavizado para que se vea mejor
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 2. Dibujar las líneas azules (Ajustamos el grosor a 5.0f)
        g2d.setStroke(new BasicStroke(5.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.setColor(Color.BLUE);
        for (int i = 0; i < puntos.length - 1; i++) {
            g2d.drawLine(puntos[i][0], puntos[i][1], puntos[i+1][0], puntos[i+1][1]);
        }

        // 3. Dibujar los puntos rojos de control (Aumentamos tamaño a 14x14)
        g2d.setColor(Color.RED);
        for (int[] p : puntos) {
            g2d.fillOval(p[0] - 7, p[1] - 7, 14, 14);
        }

        // 4. Dibujar el vehículo
        if (icono != null) {
            g2d.drawImage(icono, x - 20, y - 20, 40, 40, this);
        }
    }
}
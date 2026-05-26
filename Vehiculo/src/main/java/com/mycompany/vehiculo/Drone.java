/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vehiculo;

/**
 *
 * @author Aleh
 */


// La clase Drone hereda de Vehiculo todo lo general (peso, distancia, tiempo, etc.)
public class Drone extends Vehiculo {
    
    // 1. ATRIBUTOS ESPECÍFICOS (Solo van una vez aquí arriba)
    private String tipoDrone;
    private double cargaMaximaDrone;
    private boolean pilotoCertificadoDelivery;
    private boolean droneRegistrado;
    private double bateriaDisponible;

    // 2. CONSTRUCTOR CON PARÁMETROS
    public Drone(String nombre, double peso, double tiempo, double dist, double costoB,
                 String tipo, double cargaMax, boolean certificado, boolean registrado, double bateria) {
        
        // super manda los datos generales a la clase padre Vehiculo
        super(nombre, peso, tiempo, dist, costoB); 
        
        // Aquí guardamos los datos específicos en nuestros atributos de arriba
        this.tipoDrone = tipo;
        this.cargaMaximaDrone = cargaMax;
        this.pilotoCertificadoDelivery = certificado;
        this.droneRegistrado = registrado;
        this.bateriaDisponible = bateria;
    } // <- Esta llave cierra el constructor. ¡Súper importante!

    // 3. MÉTODO DE VALIDACIÓN (Tu último IF corregido)
    @Override
    public boolean validarCondicionesEntrega() {
        if (!this.pilotoCertificadoDelivery) {
            return false;
        }
        if (!this.droneRegistrado) {
            return false;
        }
        if (this.pesoPaquete > this.cargaMaximaDrone) {
            return false;
        }
        // Este es el último if de la lista de condiciones
        if (this.bateriaDisponible < 20.0) {
            return false;
        }
        
        return true; // Si pasa todos los "if", la entrega es segura
    }

    // 4. MÉTODO DE CÁLCULO DE COSTO
    @Override
    public double calcularCostoServicio() {
        return this.costoBase + (this.distanciaKm * 2000) + 10000;
    }
}
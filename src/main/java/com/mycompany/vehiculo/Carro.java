/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vehiculo;

/**
 *
 * @author Aleh
 */
class Carro extends Vehiculo {
    public Carro(String nombre, double peso, double tiempo, double dist, double costoB) {
        super(nombre, peso, tiempo, dist, costoB);
    }

    @Override
    public boolean validarCondicionesEntrega() {
        return this.pesoPaquete <= 50.0; // Máximo 50kg
    }

    @Override
    public double calcularCostoServicio() {
        double adicional = 0;
        if (this.pesoPaquete > 30.0) { adicional = 5000; } // Costo adicional por peso
        return this.costoBase + (this.distanciaKm * 1500) + adicional;
    }
}

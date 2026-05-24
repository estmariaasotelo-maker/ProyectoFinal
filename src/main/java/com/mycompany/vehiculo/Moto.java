/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vehiculo;

/**
 *
 * @author Aleh
 */

public class Moto extends Vehiculo {

    public Moto(String nombre, double peso, double tiempo, double dist, double costoB) {
        super(nombre, peso, tiempo, dist, costoB);
    }

    @Override
    public boolean validarCondicionesEntrega() {
        return this.pesoPaquete <= 20.0;
    }

    @Override
    public double calcularCostoServicio() {
        return this.costoBase + (this.distanciaKm * 800);
    }
}
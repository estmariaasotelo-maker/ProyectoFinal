/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vehiculo;

/**
 *
 * @author Aleh
 */


// ==========================================
// 1. CLASE ABSTRACTA BASE
// ==========================================

public abstract class Vehiculo {
    protected String nombreVehiculo;
    protected double pesoPaquete;
    protected double tiempoRecorrido;
    protected double distanciaKm;
    protected double costoBase;

    public Vehiculo() {
    }

    public Vehiculo(String nombreVehiculo, double pesoPaquete, double tiempoRecorrido, double distanciaKm, double costoBase) {
        this.nombreVehiculo = nombreVehiculo;
        this.pesoPaquete = pesoPaquete;
        this.tiempoRecorrido = tiempoRecorrido;
        this.distanciaKm = distanciaKm;
        this.costoBase = costoBase;
    }

    // Método ordinario solicitado por la guía
    public double calcularCostoServicio() {
        return this.costoBase;
    }

    // CORREGIDO: Ahora tiene la 'c' exacta para que tus clases hijas compilen
    public abstract boolean validarCondicionesEntrega();

    public String getNombreVehiculo() { return nombreVehiculo; }
    public void setNombreVehiculo(String nombreVehiculo) { this.nombreVehiculo = nombreVehiculo; }
    public double getPesoPaquete() { return pesoPaquete; }
    public void setPesoPaquete(double pesoPaquete) { this.pesoPaquete = pesoPaquete; }
    public double getTiempoRecorrido() { return tiempoRecorrido; }
    public void setTiempoRecorrido(double tiempoRecorrido) { this.tiempoRecorrido = tiempoRecorrido; }
    public double getDistanciaKm() { return distanciaKm; }
    public void setDistanciaKm(double distanciaKm) { this.distanciaKm = distanciaKm; }
    public double getCostoBase() { return costoBase; }
    public void setCostoBase(double costoBase) { this.costoBase = costoBase; }
}
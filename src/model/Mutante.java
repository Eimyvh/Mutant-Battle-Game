package model;

import game.Equipo;

public class Mutante {

    private String nombre;
    private double energiaActual;
    private int capacidadDefensa;
    private double velocidad;
    private double posicionX;
    private double posicionY;
    private IPower poder;
    private Equipo equipo;

    public Mutante(String nombre, double energiaActual, int capacidadDefensa,
               double velocidad, double posicionX, double posicionY,
               IPower poder, Equipo equipo) {

    this.nombre = nombre;
    this.energiaActual = energiaActual;
    this.capacidadDefensa = capacidadDefensa;
    this.velocidad = velocidad;
    this.posicionX = posicionX;
    this.posicionY = posicionY;
    this.poder = poder;
    this.equipo = equipo;
}
public void mover() {
    posicionX += velocidad;
    posicionY += velocidad;
}
}